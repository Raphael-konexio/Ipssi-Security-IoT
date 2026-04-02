package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public interface StreamSegmentDecrypter {
    void decryptSegment(ByteBuffer byteBuffer, int i, boolean z, ByteBuffer byteBuffer2);

    void init(ByteBuffer byteBuffer, byte[] bArr);
}
