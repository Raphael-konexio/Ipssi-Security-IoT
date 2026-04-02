package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class h {
    private static final Pattern i = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<String> f933a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, c> f934b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Pattern f935c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f936d;
    private boolean e;
    private final String f;
    private Pattern g;
    private final String h;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f937a;

        /* renamed from: b  reason: collision with root package name */
        private String f938b;

        /* renamed from: c  reason: collision with root package name */
        private String f939c;

        public h a() {
            return new h(this.f937a, this.f938b, this.f939c);
        }

        public a b(String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.f938b = str;
            return this;
        }

        public a c(String str) {
            this.f939c = str;
            return this;
        }

        public a d(String str) {
            this.f937a = str;
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements Comparable<b> {
        String f;
        String g;

        b(String str) {
            String[] split = str.split("/", -1);
            this.f = split[0];
            this.g = split[1];
        }

        @Override // java.lang.Comparable
        /* renamed from: d */
        public int compareTo(b bVar) {
            int i = this.f.equals(bVar.f) ? 2 : 0;
            return this.g.equals(bVar.g) ? i + 1 : i;
        }
    }

    /* loaded from: classes.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private String f940a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<String> f941b = new ArrayList<>();

        c() {
        }

        void a(String str) {
            this.f941b.add(str);
        }

        String b(int i) {
            return this.f941b.get(i);
        }

        String c() {
            return this.f940a;
        }

        void d(String str) {
            this.f940a = str;
        }

        public int e() {
            return this.f941b.size();
        }
    }

    h(String str, String str2, String str3) {
        this.f935c = null;
        this.f936d = false;
        this.e = false;
        this.g = null;
        this.f = str2;
        this.h = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.e = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!i.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.e) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    a(str.substring(0, matcher.start()), sb, compile);
                }
                this.f936d = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    c cVar = new c();
                    int i2 = 0;
                    while (matcher2.find()) {
                        cVar.a(matcher2.group(1));
                        sb2.append(Pattern.quote(queryParameter.substring(i2, matcher2.start())));
                        sb2.append("(.+?)?");
                        i2 = matcher2.end();
                    }
                    if (i2 < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(i2)));
                    }
                    cVar.d(sb2.toString().replace(".*", "\\E.*\\Q"));
                    this.f934b.put(str4, cVar);
                }
            } else {
                this.f936d = a(str, sb, compile);
            }
            this.f935c = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"), 2);
        }
        if (str3 != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                throw new IllegalArgumentException("The given mimeType " + str3 + " does not match to required \"type/subtype\" format");
            }
            b bVar = new b(str3);
            this.g = Pattern.compile(("^(" + bVar.f + "|[*]+)/(" + bVar.g + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
        }
    }

    private boolean a(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int i2 = 0;
        while (matcher.find()) {
            this.f933a.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i2, matcher.start())));
            sb.append("(.+?)");
            i2 = matcher.end();
            z = false;
        }
        if (i2 < str.length()) {
            sb.append(Pattern.quote(str.substring(i2)));
        }
        sb.append("($|(\\?(.)*))");
        return z;
    }

    private boolean f(Bundle bundle, String str, String str2, d dVar) {
        if (dVar == null) {
            bundle.putString(str, str2);
            return false;
        }
        try {
            dVar.a().g(bundle, str, str2);
            return false;
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public String b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle c(Uri uri, Map<String, d> map) {
        Matcher matcher;
        Matcher matcher2 = this.f935c.matcher(uri.toString());
        if (matcher2.matches()) {
            Bundle bundle = new Bundle();
            int size = this.f933a.size();
            int i2 = 0;
            while (i2 < size) {
                String str = this.f933a.get(i2);
                i2++;
                if (f(bundle, str, Uri.decode(matcher2.group(i2)), map.get(str))) {
                    return null;
                }
            }
            if (this.e) {
                for (String str2 : this.f934b.keySet()) {
                    c cVar = this.f934b.get(str2);
                    String queryParameter = uri.getQueryParameter(str2);
                    if (queryParameter != null) {
                        matcher = Pattern.compile(cVar.c()).matcher(queryParameter);
                        if (!matcher.matches()) {
                            return null;
                        }
                    } else {
                        matcher = null;
                    }
                    for (int i3 = 0; i3 < cVar.e(); i3++) {
                        String decode = matcher != null ? Uri.decode(matcher.group(i3 + 1)) : null;
                        String b2 = cVar.b(i3);
                        d dVar = map.get(b2);
                        if (decode != null && !decode.replaceAll("[{}]", "").equals(b2) && f(bundle, b2, decode, dVar)) {
                            return null;
                        }
                    }
                }
            }
            return bundle;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(String str) {
        if (this.h == null || !this.g.matcher(str).matches()) {
            return -1;
        }
        return new b(this.h).compareTo(new b(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f936d;
    }
}
