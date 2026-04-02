package com.google.crypto.tink.subtle.prf;

import java.io.InputStream;
/* loaded from: classes.dex */
public interface StreamingPrf {
    InputStream computePrf(byte[] bArr);
}
