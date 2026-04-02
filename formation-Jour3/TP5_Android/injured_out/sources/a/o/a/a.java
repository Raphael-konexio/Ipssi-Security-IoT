package a.o.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AesGcmKeyManager;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.daead.AesSivKeyManager;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.subtle.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class a implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f323a;

    /* renamed from: b  reason: collision with root package name */
    final List<SharedPreferences.OnSharedPreferenceChangeListener> f324b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final String f325c;

    /* renamed from: d  reason: collision with root package name */
    final Aead f326d;
    final DeterministicAead e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0023a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f327a;

        static {
            int[] iArr = new int[c.values().length];
            f327a = iArr;
            try {
                iArr[c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f327a[c.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f327a[c.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f327a[c.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f327a[c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f327a[c.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        private final a f328a;

        /* renamed from: b  reason: collision with root package name */
        private final SharedPreferences.Editor f329b;

        /* renamed from: d  reason: collision with root package name */
        private AtomicBoolean f331d = new AtomicBoolean(false);

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f330c = new CopyOnWriteArrayList();

        b(a aVar, SharedPreferences.Editor editor) {
            this.f328a = aVar;
            this.f329b = editor;
        }

        private void a() {
            if (this.f331d.getAndSet(false)) {
                for (String str : this.f328a.getAll().keySet()) {
                    if (!this.f330c.contains(str) && !this.f328a.g(str)) {
                        this.f329b.remove(this.f328a.d(str));
                    }
                }
            }
        }

        private void b() {
            for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.f328a.f324b) {
                for (String str : this.f330c) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.f328a, str);
                }
            }
        }

        private void c(String str, byte[] bArr) {
            if (this.f328a.g(str)) {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
            this.f330c.add(str);
            if (str == null) {
                str = "__NULL__";
            }
            try {
                Pair<String, String> e = this.f328a.e(str, bArr);
                this.f329b.putString((String) e.first, (String) e.second);
            } catch (GeneralSecurityException e2) {
                throw new SecurityException("Could not encrypt data: " + e2.getMessage(), e2);
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            a();
            this.f329b.apply();
            b();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f331d.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            a();
            try {
                return this.f329b.commit();
            } finally {
                b();
                this.f330c.clear();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(c.BOOLEAN.e());
            allocate.put(z ? (byte) 1 : (byte) 0);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(c.FLOAT.e());
            allocate.putFloat(f);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(c.INT.e());
            allocate.putInt(i);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(c.LONG.e());
            allocate.putLong(j);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(c.STRING.e());
            allocate.putInt(length);
            allocate.put(bytes);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new a.d.b<>();
                set.add("__NULL__");
            }
            ArrayList<byte[]> arrayList = new ArrayList(set.size());
            int size = set.size() * 4;
            for (String str2 : set) {
                byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes);
                size += bytes.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(size + 4);
            allocate.putInt(c.STRING_SET.e());
            for (byte[] bArr : arrayList) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            if (!this.f328a.g(str)) {
                this.f329b.remove(this.f328a.d(str));
                this.f330c.remove(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum c {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);
        
        private final int f;

        c(int i) {
            this.f = i;
        }

        public static c d(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return BOOLEAN;
                            }
                            return FLOAT;
                        }
                        return LONG;
                    }
                    return INT;
                }
                return STRING_SET;
            }
            return STRING;
        }

        public int e() {
            return this.f;
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        AES256_SIV(AesSivKeyManager.aes256SivTemplate());
        
        private final KeyTemplate f;

        d(KeyTemplate keyTemplate) {
            this.f = keyTemplate;
        }

        KeyTemplate d() {
            return this.f;
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        AES256_GCM(AesGcmKeyManager.aes256GcmTemplate());
        
        private final KeyTemplate f;

        e(KeyTemplate keyTemplate) {
            this.f = keyTemplate;
        }

        KeyTemplate d() {
            return this.f;
        }
    }

    a(String str, String str2, SharedPreferences sharedPreferences, Aead aead, DeterministicAead deterministicAead) {
        this.f325c = str;
        this.f323a = sharedPreferences;
        this.f326d = aead;
        this.e = deterministicAead;
    }

    public static SharedPreferences a(Context context, String str, a.o.a.b bVar, d dVar, e eVar) {
        return b(str, bVar.a(), context, dVar, eVar);
    }

    @Deprecated
    public static SharedPreferences b(String str, String str2, Context context, d dVar, e eVar) {
        TinkConfig.register();
        Context applicationContext = context.getApplicationContext();
        AndroidKeysetManager.Builder withSharedPref = new AndroidKeysetManager.Builder().withKeyTemplate(dVar.d()).withSharedPref(applicationContext, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str);
        KeysetHandle keysetHandle = withSharedPref.withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str2).build().getKeysetHandle();
        AndroidKeysetManager.Builder withSharedPref2 = new AndroidKeysetManager.Builder().withKeyTemplate(eVar.d()).withSharedPref(applicationContext, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str);
        KeysetHandle keysetHandle2 = withSharedPref2.withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str2).build().getKeysetHandle();
        DeterministicAead deterministicAead = (DeterministicAead) keysetHandle.getPrimitive(DeterministicAead.class);
        return new a(str, str2, applicationContext.getSharedPreferences(str, 0), (Aead) keysetHandle2.getPrimitive(Aead.class), deterministicAead);
    }

    private Object f(String str) {
        if (g(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String d2 = d(str);
            String string = this.f323a.getString(d2, null);
            if (string != null) {
                ByteBuffer wrap = ByteBuffer.wrap(this.f326d.decrypt(Base64.decode(string, 0), d2.getBytes(StandardCharsets.UTF_8)));
                wrap.position(0);
                switch (C0023a.f327a[c.d(wrap.getInt()).ordinal()]) {
                    case 1:
                        int i = wrap.getInt();
                        ByteBuffer slice = wrap.slice();
                        wrap.limit(i);
                        String charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                        if (charBuffer.equals("__NULL__")) {
                            return null;
                        }
                        return charBuffer;
                    case 2:
                        return Integer.valueOf(wrap.getInt());
                    case 3:
                        return Long.valueOf(wrap.getLong());
                    case 4:
                        return Float.valueOf(wrap.getFloat());
                    case 5:
                        return Boolean.valueOf(wrap.get() != 0);
                    case 6:
                        a.d.b bVar = new a.d.b();
                        while (wrap.hasRemaining()) {
                            int i2 = wrap.getInt();
                            ByteBuffer slice2 = wrap.slice();
                            slice2.limit(i2);
                            wrap.position(wrap.position() + i2);
                            bVar.add(StandardCharsets.UTF_8.decode(slice2).toString());
                        }
                        if (bVar.size() == 1 && "__NULL__".equals(bVar.s(0))) {
                            return null;
                        }
                        return bVar;
                    default:
                        return null;
                }
            }
            return null;
        } catch (GeneralSecurityException e2) {
            throw new SecurityException("Could not decrypt value. " + e2.getMessage(), e2);
        }
    }

    String c(String str) {
        try {
            String str2 = new String(this.e.decryptDeterministically(Base64.decode(str, 0), this.f325c.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals("__NULL__")) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e2) {
            throw new SecurityException("Could not decrypt key. " + e2.getMessage(), e2);
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (!g(str)) {
            return this.f323a.contains(d(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    String d(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return Base64.encode(this.e.encryptDeterministically(str.getBytes(StandardCharsets.UTF_8), this.f325c.getBytes()));
        } catch (GeneralSecurityException e2) {
            throw new SecurityException("Could not encrypt key. " + e2.getMessage(), e2);
        }
    }

    Pair<String, String> e(String str, byte[] bArr) {
        String d2 = d(str);
        return new Pair<>(d2, Base64.encode(this.f326d.encrypt(bArr, d2.getBytes(StandardCharsets.UTF_8))));
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new b(this, this.f323a.edit());
    }

    boolean g(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : this.f323a.getAll().entrySet()) {
            if (!g(entry.getKey())) {
                String c2 = c(entry.getKey());
                hashMap.put(c2, f(c2));
            }
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        Object f = f(str);
        return (f == null || !(f instanceof Boolean)) ? z : ((Boolean) f).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        Object f2 = f(str);
        return (f2 == null || !(f2 instanceof Float)) ? f : ((Float) f2).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object f = f(str);
        return (f == null || !(f instanceof Integer)) ? i : ((Integer) f).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        Object f = f(str);
        return (f == null || !(f instanceof Long)) ? j : ((Long) f).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object f = f(str);
        return (f == null || !(f instanceof String)) ? str2 : (String) f;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Object f = f(str);
        Set<String> bVar = f instanceof Set ? (Set) f : new a.d.b<>();
        return bVar.size() > 0 ? bVar : set;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f324b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f324b.remove(onSharedPreferenceChangeListener);
    }
}
