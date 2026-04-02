package com.google.firebase.database.s;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class a {

    /* renamed from: com.google.firebase.database.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0106a implements b {

        /* renamed from: b  reason: collision with root package name */
        private int f2374b = 0;

        /* renamed from: a  reason: collision with root package name */
        private List<byte[]> f2373a = new ArrayList();

        C0106a() {
        }

        @Override // com.google.firebase.database.s.a.b
        public boolean a(byte[] bArr) {
            this.f2373a.add(bArr);
            this.f2374b += bArr.length;
            return true;
        }

        @Override // com.google.firebase.database.s.a.b
        public g b() {
            byte[] bArr = new byte[this.f2374b];
            int i = 0;
            for (int i2 = 0; i2 < this.f2373a.size(); i2++) {
                byte[] bArr2 = this.f2373a.get(i2);
                System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
                i += bArr2.length;
            }
            return new g(bArr);
        }
    }

    /* loaded from: classes.dex */
    interface b {
        boolean a(byte[] bArr);

        g b();
    }

    /* loaded from: classes.dex */
    static class c implements b {

        /* renamed from: c  reason: collision with root package name */
        private static ThreadLocal<CharsetDecoder> f2375c = new C0107a();

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f2376a = new StringBuilder();

        /* renamed from: b  reason: collision with root package name */
        private ByteBuffer f2377b;

        /* renamed from: com.google.firebase.database.s.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0107a extends ThreadLocal<CharsetDecoder> {
            C0107a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public CharsetDecoder initialValue() {
                CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
                newDecoder.onMalformedInput(CodingErrorAction.REPORT);
                newDecoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                return newDecoder;
            }
        }

        /* loaded from: classes.dex */
        class b extends ThreadLocal<CharsetEncoder> {
            b() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public CharsetEncoder initialValue() {
                CharsetEncoder newEncoder = Charset.forName("UTF8").newEncoder();
                newEncoder.onMalformedInput(CodingErrorAction.REPORT);
                newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                return newEncoder;
            }
        }

        static {
            new b();
        }

        c() {
        }

        private String c(byte[] bArr) {
            try {
                return f2375c.get().decode(ByteBuffer.wrap(bArr)).toString();
            } catch (CharacterCodingException unused) {
                return null;
            }
        }

        @Override // com.google.firebase.database.s.a.b
        public boolean a(byte[] bArr) {
            String c2 = c(bArr);
            if (c2 != null) {
                this.f2376a.append(c2);
                return true;
            }
            return false;
        }

        @Override // com.google.firebase.database.s.a.b
        public g b() {
            if (this.f2377b != null) {
                return null;
            }
            return new g(this.f2376a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(byte b2) {
        return b2 == 2 ? new C0106a() : new c();
    }
}
