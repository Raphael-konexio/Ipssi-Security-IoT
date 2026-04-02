package com.google.crypto.tink.subtle;

import com.google.crypto.tink.annotations.Alpha;
import java.security.InvalidKeyException;
import java.util.Arrays;
@Alpha
/* loaded from: classes.dex */
final class Curve25519 {
    static final byte[][] BANNED_PUBLIC_KEYS = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, 22, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, 50, -79, -3, -122, 98, 5, 22, 95, 73, -72, 0}, new byte[]{95, -100, -107, -68, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, -17, 91, 4, 68, 92, -60, 88, 28, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}};

    Curve25519() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyConditional(long[] jArr, long[] jArr2, int i) {
        int i2 = -i;
        for (int i3 = 0; i3 < 10; i3++) {
            jArr[i3] = ((((int) jArr2[i3]) ^ ((int) jArr[i3])) & i2) ^ ((int) jArr[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void curveMult(long[] jArr, byte[] bArr, byte[] bArr2) {
        validatePubKeyAndClearMsb(bArr2);
        long[] expand = Field25519.expand(bArr2);
        long[] jArr2 = new long[19];
        long[] jArr3 = new long[19];
        jArr3[0] = 1;
        long[] jArr4 = new long[19];
        jArr4[0] = 1;
        long[] jArr5 = new long[19];
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        jArr7[0] = 1;
        long[] jArr8 = new long[19];
        long[] jArr9 = new long[19];
        jArr9[0] = 1;
        System.arraycopy(expand, 0, jArr2, 0, 10);
        int i = 0;
        while (i < 32) {
            int i2 = bArr[(32 - i) - 1] & 255;
            long[] jArr10 = jArr6;
            long[] jArr11 = jArr7;
            long[] jArr12 = jArr2;
            long[] jArr13 = jArr3;
            long[] jArr14 = jArr8;
            int i3 = 0;
            long[] jArr15 = jArr9;
            long[] jArr16 = jArr5;
            long[] jArr17 = jArr4;
            long[] jArr18 = jArr16;
            while (i3 < 8) {
                int i4 = (i2 >> (7 - i3)) & 1;
                swapConditional(jArr17, jArr12, i4);
                swapConditional(jArr18, jArr13, i4);
                long[] jArr19 = jArr14;
                long[] jArr20 = jArr11;
                int i5 = i2;
                long[] jArr21 = jArr10;
                long[] jArr22 = jArr18;
                long[] jArr23 = jArr17;
                long[] jArr24 = jArr13;
                long[] jArr25 = jArr12;
                monty(jArr14, jArr15, jArr10, jArr11, jArr17, jArr18, jArr12, jArr13, expand);
                swapConditional(jArr19, jArr21, i4);
                swapConditional(jArr15, jArr20, i4);
                i3++;
                jArr13 = jArr20;
                jArr18 = jArr15;
                jArr17 = jArr19;
                jArr12 = jArr21;
                i2 = i5;
                jArr15 = jArr22;
                jArr14 = jArr23;
                jArr11 = jArr24;
                jArr10 = jArr25;
            }
            long[] jArr26 = jArr17;
            long[] jArr27 = jArr13;
            long[] jArr28 = jArr12;
            jArr7 = jArr11;
            i++;
            jArr9 = jArr15;
            jArr8 = jArr14;
            jArr6 = jArr10;
            jArr5 = jArr18;
            jArr4 = jArr26;
            jArr3 = jArr27;
            jArr2 = jArr28;
        }
        long[] jArr29 = new long[10];
        Field25519.inverse(jArr29, jArr5);
        Field25519.mult(jArr, jArr4, jArr29);
        if (isCollinear(expand, jArr, jArr2, jArr3)) {
            return;
        }
        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: " + Hex.encode(bArr2));
    }

    private static boolean isCollinear(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[11];
        long[] jArr8 = new long[11];
        long[] jArr9 = new long[11];
        Field25519.mult(jArr5, jArr, jArr2);
        Field25519.sum(jArr6, jArr, jArr2);
        long[] jArr10 = new long[10];
        jArr10[0] = 486662;
        Field25519.sum(jArr8, jArr6, jArr10);
        Field25519.mult(jArr8, jArr8, jArr4);
        Field25519.sum(jArr8, jArr3);
        Field25519.mult(jArr8, jArr8, jArr5);
        Field25519.mult(jArr8, jArr8, jArr3);
        Field25519.scalarProduct(jArr7, jArr8, 4L);
        Field25519.reduceCoefficients(jArr7);
        Field25519.mult(jArr8, jArr5, jArr4);
        Field25519.sub(jArr8, jArr8, jArr4);
        Field25519.mult(jArr9, jArr6, jArr3);
        Field25519.sum(jArr8, jArr8, jArr9);
        Field25519.square(jArr8, jArr8);
        return Bytes.equal(Field25519.contract(jArr7), Field25519.contract(jArr8));
    }

    private static void monty(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5, long[] jArr6, long[] jArr7, long[] jArr8, long[] jArr9) {
        long[] copyOf = Arrays.copyOf(jArr5, 10);
        long[] jArr10 = new long[19];
        long[] jArr11 = new long[19];
        long[] jArr12 = new long[19];
        long[] jArr13 = new long[19];
        long[] jArr14 = new long[19];
        long[] jArr15 = new long[19];
        long[] jArr16 = new long[19];
        Field25519.sum(jArr5, jArr6);
        Field25519.sub(jArr6, copyOf);
        long[] copyOf2 = Arrays.copyOf(jArr7, 10);
        Field25519.sum(jArr7, jArr8);
        Field25519.sub(jArr8, copyOf2);
        Field25519.product(jArr13, jArr7, jArr6);
        Field25519.product(jArr14, jArr5, jArr8);
        Field25519.reduceSizeByModularReduction(jArr13);
        Field25519.reduceCoefficients(jArr13);
        Field25519.reduceSizeByModularReduction(jArr14);
        Field25519.reduceCoefficients(jArr14);
        System.arraycopy(jArr13, 0, copyOf2, 0, 10);
        Field25519.sum(jArr13, jArr14);
        Field25519.sub(jArr14, copyOf2);
        Field25519.square(jArr16, jArr13);
        Field25519.square(jArr15, jArr14);
        Field25519.product(jArr14, jArr15, jArr9);
        Field25519.reduceSizeByModularReduction(jArr14);
        Field25519.reduceCoefficients(jArr14);
        System.arraycopy(jArr16, 0, jArr3, 0, 10);
        System.arraycopy(jArr14, 0, jArr4, 0, 10);
        Field25519.square(jArr11, jArr5);
        Field25519.square(jArr12, jArr6);
        Field25519.product(jArr, jArr11, jArr12);
        Field25519.reduceSizeByModularReduction(jArr);
        Field25519.reduceCoefficients(jArr);
        Field25519.sub(jArr12, jArr11);
        Arrays.fill(jArr10, 10, 18, 0L);
        Field25519.scalarProduct(jArr10, jArr12, 121665L);
        Field25519.reduceCoefficients(jArr10);
        Field25519.sum(jArr10, jArr11);
        Field25519.product(jArr2, jArr12, jArr10);
        Field25519.reduceSizeByModularReduction(jArr2);
        Field25519.reduceCoefficients(jArr2);
    }

    static void swapConditional(long[] jArr, long[] jArr2, int i) {
        int i2 = -i;
        for (int i3 = 0; i3 < 10; i3++) {
            int i4 = (((int) jArr2[i3]) ^ ((int) jArr[i3])) & i2;
            jArr[i3] = ((int) jArr[i3]) ^ i4;
            jArr2[i3] = i4 ^ ((int) jArr2[i3]);
        }
    }

    private static void validatePubKeyAndClearMsb(byte[] bArr) {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
        bArr[31] = (byte) (bArr[31] & Byte.MAX_VALUE);
        int i = 0;
        while (true) {
            byte[][] bArr2 = BANNED_PUBLIC_KEYS;
            if (i >= bArr2.length) {
                return;
            }
            if (Bytes.equal(bArr2[i], bArr)) {
                throw new InvalidKeyException("Banned public key: " + Hex.encode(BANNED_PUBLIC_KEYS[i]));
            }
            i++;
        }
    }
}
