package com.diluv.catalejo.tests;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.diluv.catalejo.Catalejo;

public class WideRangeFileTests {

    @Test
    @DisplayName("Test Bedrock Addon File")
    void testBedrockAddonFile () {

        final Catalejo catalejo = this.getCatalejoInstance();
        final File file = new File("src/test/resources/testfiles/bedrock_addon.mcaddon");
        final Map<String, Object> meta = new HashMap<>();

        try {

            catalejo.readFileMeta(meta, file);

            Assertions.assertEquals(meta.get("Extension"), "mcaddon");
            Assertions.assertEquals(meta.get("FileName"), "bedrock_addon.mcaddon");
            Assertions.assertEquals(meta.get("Bytes"), 19362L);
            Assertions.assertEquals(meta.get("Size"), "18 KB");
            Assertions.assertEquals(meta.get("SHA"), "4773d7a880ddef5e2ee5d484cbee1de0f8833bba");
            Assertions.assertEquals(meta.get("SHA-224"), "12df52f12a85ffc153fa034ce331978f3e37a726b80214a53a050c1a");
            Assertions.assertEquals(meta.get("SHA-256"), "c6119f578513783a6b80e2f0f5f68e3e15ec138037ba2da44ac7d804d3f6fd50");
            Assertions.assertEquals(meta.get("SHA-384"), "841a34130df7826817862fc3efe8653cde6c20b6467f675631d0d3f9043369e19800d0b58290c33fd693a1e0d320efaa");
            Assertions.assertEquals(meta.get("SHA-512"), "20920e6c193b7d51b91c873afc617776951af292ccc12e884420f09d06076602201e4b4a630442bb7e083b72822676e5204b7bc29d60c135f30593910d684b73");
            Assertions.assertEquals(meta.get("MD2"), "4fd59798e9a4c106150c25071db16f83");
            Assertions.assertEquals(meta.get("MD5"), "fa73b4dd11fcdabcaba5bf074cd394d1");
            Assertions.assertEquals(meta.get("CRC32"), "c55165ba");
        }

        catch (final Exception e) {

            Assertions.fail(e);
        }
    }

    @Test
    @DisplayName("Test Bedrock Resourcepack File")
    void testBedrockResourcepackFile () {

        final Catalejo catalejo = this.getCatalejoInstance();
        final File file = new File("src/test/resources/testfiles/bedrock_resourcepack.mcpack");
        final Map<String, Object> meta = new HashMap<>();

        try {

            catalejo.readFileMeta(meta, file);

            Assertions.assertEquals(meta.get("Extension"), "mcpack");
            Assertions.assertEquals(meta.get("FileName"), "bedrock_resourcepack.mcpack");
            Assertions.assertEquals(meta.get("Bytes"), 1022L);
            Assertions.assertEquals(meta.get("Size"), "1022 bytes");
            Assertions.assertEquals(meta.get("SHA"), "58cb2628ae190bd98c05135d1fb57330eb4f08da");
            Assertions.assertEquals(meta.get("SHA-224"), "a34cea1589b7b44d4d1f180d051670101c8c37809566520d970b422a");
            Assertions.assertEquals(meta.get("SHA-256"), "9950a2f5a0f95ca254cedf93a007cb48df6732bcb29c0b7a516e7f085257a00a");
            Assertions.assertEquals(meta.get("SHA-384"), "b22b0b22600faa3043ed1d9ddbbe0ddc9efed4d4c7099effd574f57873ae37e6e26b3e714d3688368baed8014a9054ef");
            Assertions.assertEquals(meta.get("SHA-512"), "36a11a4c75b2e58ea82d62870859f413f1ca2295c74a06e92be4c31830ab55f86a5526622700c84b1e16b6b03b174fa8084534d8f709edd99e718d76b9fc4776");
            Assertions.assertEquals(meta.get("MD2"), "27511e665ec3482670fe3b0934872556");
            Assertions.assertEquals(meta.get("MD5"), "67b1d073fd9bc3cd1b71b50cbcd9a949");
            Assertions.assertEquals(meta.get("CRC32"), "2dfa4c36");
        }

        catch (final Exception e) {

            Assertions.fail(e);
        }
    }

    @Test
    @DisplayName("Test Forge Jar File")
    void testForgeJarFile () {

        final Catalejo catalejo = this.getCatalejoInstance();
        final File file = new File("src/test/resources/testfiles/forge_mod.jar");
        final Map<String, Object> meta = new HashMap<>();

        try {

            catalejo.readFileMeta(meta, file);

            Assertions.assertEquals(meta.get("Extension"), "jar");
            Assertions.assertEquals(meta.get("FileName"), "forge_mod.jar");
            Assertions.assertEquals(meta.get("Bytes"), 105599L);
            Assertions.assertEquals(meta.get("Size"), "103 KB");
            Assertions.assertEquals(meta.get("SHA"), "8fcf0b34c44a6e1894ee4dbfb7582e41f45f9e77");
            Assertions.assertEquals(meta.get("SHA-224"), "4b0febd784c47aa59750a8d146b775305a8e5e5571405d04ff7b020c");
            Assertions.assertEquals(meta.get("SHA-256"), "3220be56b349536e3cc1f07c4818a75c8c878711fa390a2f64625a7be0d329a2");
            Assertions.assertEquals(meta.get("SHA-384"), "4094c06b5c8a0829880fdb5ac3f9c49000085179efe51d6b4b307ba4c08e1b6eef40a4e84f64a1e35d93a0714a17043d");
            Assertions.assertEquals(meta.get("SHA-512"), "4f5446b2a183524b93cd05042b62f951e06db4d4d889c54ef969637a0a0d64de07b21f91c4aa627777064f7669c3f56c7b5bd8a5bc7e7dc3cccd7ea8a96b4022");
            Assertions.assertEquals(meta.get("MD2"), "21b6b083888f03662343e8f9d9152874");
            Assertions.assertEquals(meta.get("MD5"), "465197ce603bc4deffc79d775dec5908");
            Assertions.assertEquals(meta.get("CRC32"), "3b59e489");
        }

        catch (final Exception e) {

            Assertions.fail(e);
        }
    }

    @Test
    @DisplayName("Test JPEG Image File")
    void testJPEGImageFile () {

        final Catalejo catalejo = this.getCatalejoInstance();
        final File file = new File("src/test/resources/testfiles/image.jpg");
        final Map<String, Object> meta = new HashMap<>();

        try {

            catalejo.readFileMeta(meta, file);

            Assertions.assertEquals(meta.get("Extension"), "jpg");
            Assertions.assertEquals(meta.get("FileName"), "image.jpg");
            Assertions.assertEquals(meta.get("Bytes"), 2000291L);
            Assertions.assertEquals(meta.get("Size"), "1 MB");
            Assertions.assertEquals(meta.get("SHA"), "92b5657671f48ce5dfb7a0e7a2d09387993d0b2a");
            Assertions.assertEquals(meta.get("SHA-224"), "5b82574859664ba58eea7ee524b59164f22a0a850a85b5cc081e7385");
            Assertions.assertEquals(meta.get("SHA-256"), "ec2e6dc43dd5937fac6e63b55f8a729e4c6f13ee036737d068d68f7d83fe7423");
            Assertions.assertEquals(meta.get("SHA-384"), "ea54a322a9be3a9ec4a755d1defade459b167bc4977c4483deeb6bda0ff6522085f2cfd5cc4df34d2958e938f0af5c4f");
            Assertions.assertEquals(meta.get("SHA-512"), "b2c0633aefb613b6faf5f3f733c1b0f85775339c67a99d896c001687d55a80f366e592be95a44785393bbfd06eb6cb677744b8c8830e4f0373b77a4f7e0dae7f");
            Assertions.assertEquals(meta.get("MD2"), "8366f4bd1585d29030ca47dc526e7c8c");
            Assertions.assertEquals(meta.get("MD5"), "e6d00814f0c410a18ba8b53314f54f4b");
            Assertions.assertEquals(meta.get("CRC32"), "b5f381a9");
        }

        catch (final Exception e) {

            Assertions.fail(e);
        }
    }

    @Test
    @DisplayName("Test PNG Image File")
    void testPNGImageFile () {

        final Catalejo catalejo = this.getCatalejoInstance();
        final File file = new File("src/test/resources/testfiles/image.png");
        final Map<String, Object> meta = new HashMap<>();

        try {

            catalejo.readFileMeta(meta, file);

            Assertions.assertEquals(meta.get("Extension"), "png");
            Assertions.assertEquals(meta.get("FileName"), "image.png");
            Assertions.assertEquals(meta.get("Bytes"), 884829L);
            Assertions.assertEquals(meta.get("Size"), "864 KB");
            Assertions.assertEquals(meta.get("SHA"), "61ce23669223782c07d6e93653891b865346453e");
            Assertions.assertEquals(meta.get("SHA-224"), "c5a076d5d51a53dcb954bb736173976b92d4fd4d2f2388f7c966f357");
            Assertions.assertEquals(meta.get("SHA-256"), "f9ec6f260e96bcac1d0d13365728dba2880b6c4c418ab19c06a4b05b8d1aa978");
            Assertions.assertEquals(meta.get("SHA-384"), "2ae2e9c9cf97d8e5a3754532f9e2f38d9487e15e538b81eb050300c57b996639814ce0108a4412d7c098f4fb5ea8c98d");
            Assertions.assertEquals(meta.get("SHA-512"), "5b12c7a51033ab4c8a97d0118fe6da5216154ba8cafa55b69b376f3a1f64d648c6f846c98a8cba87ae776b04b74b22fbd2401dff362c420c2cc5845a2ecb81e1");
            Assertions.assertEquals(meta.get("MD2"), "b738701b7d5c23fc68e6542d69181ad7");
            Assertions.assertEquals(meta.get("MD5"), "cfccc50e6d4cb9c57e778a56f27d2ace");
            Assertions.assertEquals(meta.get("CRC32"), "6f36e507");
        }

        catch (final Exception e) {

            Assertions.fail(e);
        }
    }

    @Test
    @DisplayName("Test Javascript File")
    void testJavascriptFile () {

        final Catalejo catalejo = this.getCatalejoInstance();
        final File file = new File("src/test/resources/testfiles/javascript.js");
        final Map<String, Object> meta = new HashMap<>();

        try {

            catalejo.readFileMeta(meta, file);

            Assertions.assertEquals(meta.get("Extension"), "js");
            Assertions.assertEquals(meta.get("FileName"), "javascript.js");
            Assertions.assertEquals(meta.get("Bytes"), 1517L);
            Assertions.assertEquals(meta.get("Size"), "1 KB");
            Assertions.assertEquals(meta.get("SHA"), "57f15d7c0506e0c919141daf8c0bb97a425c4aeb");
            Assertions.assertEquals(meta.get("SHA-224"), "03a89fe7f8aa95084cb3013807061a725b01ee8513609d125dc85805");
            Assertions.assertEquals(meta.get("SHA-256"), "f681f200381c751d2cb8fe36aff8a8327ea2fbc1184d73f74a23254d6aa8d87f");
            Assertions.assertEquals(meta.get("SHA-384"), "faa5f22eaa2466b64612b1e0a4d6e8e301bd52d5622c740c758d0d2903333a69d0c4d411bcee12b8eaf4350ff196d3f1");
            Assertions.assertEquals(meta.get("SHA-512"), "045f440dbf5f57834bcece2dfb1f5164ac92f06d606069632e874c93a1f5f0ab695af5ceb4217160960a0e95e2a380c4a82e42ea6305781ee9fc58846d893e77");
            Assertions.assertEquals(meta.get("MD2"), "5c5ceeb508e00f651867a1e2e5b217dc");
            Assertions.assertEquals(meta.get("MD5"), "f97a51dd46073c758e80d7f83aa74996");
            Assertions.assertEquals(meta.get("CRC32"), "e8af8e95");
        }

        catch (final Exception e) {

            Assertions.fail(e);
        }
    }

    @Test
    @DisplayName("Test Text File")
    void testTextFile () {

        final Catalejo catalejo = this.getCatalejoInstance();
        final File file = new File("src/test/resources/testfiles/text.txt");
        final Map<String, Object> meta = new HashMap<>();

        try {

            catalejo.readFileMeta(meta, file);

            Assertions.assertEquals(meta.get("Extension"), "txt");
            Assertions.assertEquals(meta.get("FileName"), "text.txt");
            Assertions.assertEquals(meta.get("Bytes"), 8578L);
            Assertions.assertEquals(meta.get("Size"), "8 KB");
            Assertions.assertEquals(meta.get("SHA"), "09087f2e216057c85397aa4c46c86592f58a2848");
            Assertions.assertEquals(meta.get("SHA-224"), "1c81b695d8cc9b5b58ca62bd6e3cd3bf681d5a258ecfe0a4f4ae3573");
            Assertions.assertEquals(meta.get("SHA-256"), "dabdfd9fdaf55b179509f0d4bdb47a4b3f1c5f64bb9f9ce0d50c8b5dc382d3e4");
            Assertions.assertEquals(meta.get("SHA-384"), "f139904308cd3f9ab8119fe34dc9b76f70503e1e1c89a99b6d709abe7bec8916d392ded14557455f42d513a5e17bd1d2");
            Assertions.assertEquals(meta.get("SHA-512"), "eebae5726c4877d89a23556c00cac9d182e217db42b757e18028254cb8d62d4e8acf7190b524870c68393cd0343f16df14469469193e78daff67b06133d07f6f");
            Assertions.assertEquals(meta.get("MD2"), "f1deb80fffe448f695b6220657d6dd53");
            Assertions.assertEquals(meta.get("MD5"), "20acf45ffa810a038d9feebe63ffb115");
            Assertions.assertEquals(meta.get("CRC32"), "5da3d40e");
        }

        catch (final Exception e) {

            Assertions.fail(e);
        }
    }

    @Test
    @DisplayName("Test Zip File")
    void testZipFile () {

        final Catalejo catalejo = this.getCatalejoInstance();
        final File file = new File("src/test/resources/testfiles/zip_archive.zip");
        final Map<String, Object> meta = new HashMap<>();

        try {

            catalejo.readFileMeta(meta, file);

            Assertions.assertEquals(meta.get("Extension"), "zip");
            Assertions.assertEquals(meta.get("FileName"), "zip_archive.zip");
            Assertions.assertEquals(meta.get("Bytes"), 22L);
            Assertions.assertEquals(meta.get("Size"), "22 bytes");
            Assertions.assertEquals(meta.get("SHA"), "b04f3ee8f5e43fa3b162981b50bb72fe1acabb33");
            Assertions.assertEquals(meta.get("SHA-224"), "a3cb5d98d33ad55b145b1d058d8ea50b3c212ad949ed85b6f7392196");
            Assertions.assertEquals(meta.get("SHA-256"), "8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85");
            Assertions.assertEquals(meta.get("SHA-384"), "35b38c9c2bfa0a9716fc424785c169b2f4b8cf9cd039ef63b502194ee482c332866f218fad8c9d00928394663ee75794");
            Assertions.assertEquals(meta.get("SHA-512"), "5e2f959f36b66df0580a94f384c5fc1ceeec4b2a3925f062d7b68f21758b86581ac2adcfdde73a171a28496e758ef1b23ca4951c05455cdae9357cc3b5a5825f");
            Assertions.assertEquals(meta.get("MD2"), "c7016fdcd79bf5a617361428548736db");
            Assertions.assertEquals(meta.get("MD5"), "76cdb2bad9582d23c1f6f4d868218d6c");
            Assertions.assertEquals(meta.get("CRC32"), "d7cbc50e");
        }

        catch (final Exception e) {

            Assertions.fail(e);
        }
    }

    Catalejo getCatalejoInstance () {

        final Catalejo catelejo = new Catalejo();
        catelejo.add(Catalejo.NAME_READER);
        catelejo.add(Catalejo.SIZE_READER);
        catelejo.add(Catalejo.MD2_READER);
        catelejo.add(Catalejo.MD5_READER);
        catelejo.add(Catalejo.SHA_READER);
        catelejo.add(Catalejo.SHA_224_READER);
        catelejo.add(Catalejo.SHA_256_READER);
        catelejo.add(Catalejo.SHA_384_READER);
        catelejo.add(Catalejo.SHA_512_READER);
        catelejo.add(Catalejo.CRC_32_READER);

        return catelejo;
    }
}