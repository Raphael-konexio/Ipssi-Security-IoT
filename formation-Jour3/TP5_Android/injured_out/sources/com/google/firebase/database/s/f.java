package com.google.firebase.database.s;

import android.util.Base64;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    private URI f2383a;

    /* renamed from: b  reason: collision with root package name */
    private String f2384b;

    /* renamed from: c  reason: collision with root package name */
    private String f2385c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f2386d;

    public f(URI uri, String str, Map<String, String> map) {
        this.f2383a = null;
        this.f2384b = null;
        this.f2385c = null;
        this.f2386d = null;
        this.f2383a = uri;
        this.f2384b = str;
        this.f2386d = map;
        this.f2385c = a();
    }

    private String a() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) d(0, 255);
        }
        return Base64.encodeToString(bArr, 2);
    }

    private String b(LinkedHashMap<String, String> linkedHashMap) {
        String str = new String();
        for (String str2 : linkedHashMap.keySet()) {
            str = str + str2 + ": " + linkedHashMap.get(str2) + "\r\n";
        }
        return str;
    }

    private int d(int i, int i2) {
        return (int) ((Math.random() * i2) + i);
    }

    public byte[] c() {
        String path = this.f2383a.getPath();
        String query = this.f2383a.getQuery();
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        sb.append(query == null ? "" : "?" + query);
        String sb2 = sb.toString();
        String host = this.f2383a.getHost();
        if (this.f2383a.getPort() != -1) {
            host = host + ":" + this.f2383a.getPort();
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Host", host);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.f2385c);
        String str = this.f2384b;
        if (str != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", str);
        }
        Map<String, String> map = this.f2386d;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!linkedHashMap.containsKey(str2)) {
                    linkedHashMap.put(str2, this.f2386d.get(str2));
                }
            }
        }
        byte[] bytes = ((("GET " + sb2 + " HTTP/1.1\r\n") + b(linkedHashMap)) + "\r\n").getBytes(Charset.defaultCharset());
        byte[] bArr = new byte[bytes.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bArr;
    }

    public void e(HashMap<String, String> hashMap) {
        if (!"websocket".equals(hashMap.get("upgrade"))) {
            throw new e("connection failed: missing header field in server handshake: Upgrade");
        }
        if (!"upgrade".equals(hashMap.get("connection"))) {
            throw new e("connection failed: missing header field in server handshake: Connection");
        }
    }

    public void f(String str) {
        int parseInt = Integer.parseInt(str.substring(9, 12));
        if (parseInt == 407) {
            throw new e("connection failed: proxy authentication not supported");
        }
        if (parseInt == 404) {
            throw new e("connection failed: 404 not found");
        }
        if (parseInt == 101) {
            return;
        }
        throw new e("connection failed: unknown status code " + parseInt);
    }
}
