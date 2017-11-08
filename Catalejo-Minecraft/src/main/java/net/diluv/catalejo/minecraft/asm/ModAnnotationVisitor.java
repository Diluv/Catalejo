package net.diluv.catalejo.minecraft.asm;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

/**
 * This annotation visitor is used to grab data from Forge's mod annotation. All
 * of the annotation parameters will be stored in a sub-map using the
 * ForgeModMeta key.
 */
public class ModAnnotationVisitor extends AnnotationVisitor {

    /**
     * A map to hold the data that is grabbed from the annotation.
     */
    private final Map<String, Object> data = new HashMap<>();

    /**
     * Constructor for a mod annotation visitor. Can be used to get all of the
     * mod annotation data.
     *
     * @param rawData The map of raw data. All data will be added as a sub map
     *        using the ForgeModMeta key.
     * @param parent The parent annotation visitor.
     */
    public ModAnnotationVisitor (Map<String, Object> rawData, AnnotationVisitor parent) {

        super(Opcodes.ASM6, parent);
        rawData.put("ForgeModMeta", this.data);
    }

    @Override
    public void visit (String name, Object value) {

        super.visit(name, value);
        this.data.put(name, value);
    }

    @Override
    public void visitEnum (String name, String desc, String value) {

        super.visitEnum(name, desc, value);
        this.data.put(name, value);
    }
}