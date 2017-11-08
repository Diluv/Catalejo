package net.diluv.catalejo.minecraft.asm;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

/**
 * This class visitor handles reading a class file and searching for annotations
 * that information can be processed.
 */
public class ModClassVisitor extends ClassVisitor {

    /**
     * Over the years forge has moved their mod annotation around to different
     * packages. This list is used to hold any possibly valid class description
     * for a mod annotation. This must be updated if forge ever moves this
     * annotation again.
     */
    private static final List<String> VALID_FORGE_MOD_ANNOTATIONS = Arrays.asList("Lfml/Mod;", "Lcpw/mods/fml/common/Mod;", "Lnet/minecraftforge/fml/common/Mod;");

    /**
     * An object level reference to the map of data for the reader to populate.
     */
    private final Map<String, Object> modData;

    /**
     * This method can be used to read a class file using ASM. If the class file
     * is invalid an exception will be thrown.
     *
     * @param modData A map of data that will be populated by the annotation
     *        scanner.
     * @param stream A stream which represents the class bytes.
     * @throws Exception It is possible for reading a class via ASM to throw an
     *         exception. The library makes no attempt to handle this exception,
     *         as swallowing the exception can be dangerous for many
     *         applications.
     */
    public static void readClassFile (Map<String, Object> modData, InputStream stream) throws Exception {

        final ClassReader cr = new ClassReader(stream);
        cr.accept(new ModClassVisitor(modData, Opcodes.ASM6), 0);
    }

    /**
     * A class visitor for reading mod annotations. This is private, use
     * {@link #readClassFile(Map, InputStream)} instead!
     *
     * @param modData A map of data to populate.
     * @param api The API level. This can be found in Opcodes.
     */
    private ModClassVisitor (Map<String, Object> modData, int api) {

        super(api);
        this.modData = modData;
    }

    @Override
    public AnnotationVisitor visitAnnotation (String desc, boolean visible) {

        final AnnotationVisitor visitor = super.visitAnnotation(desc, visible);

        // If the annotation is a forge mod annotation, process it.
        if (VALID_FORGE_MOD_ANNOTATIONS.contains(desc)) {

            return new ModAnnotationVisitor(this.modData, visitor);
        }

        return super.visitAnnotation(desc, visible);
    }
}