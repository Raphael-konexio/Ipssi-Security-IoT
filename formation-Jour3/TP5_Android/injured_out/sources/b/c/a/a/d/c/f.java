package b.c.a.a.d.c;
/* loaded from: classes.dex */
final class f extends g {

    /* renamed from: a  reason: collision with root package name */
    private final char f1250a = '.';

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(char c2) {
    }

    @Override // b.c.a.a.d.c.d
    public final boolean b(char c2) {
        return c2 == this.f1250a;
    }

    public final String toString() {
        String d2;
        d2 = d.d(this.f1250a);
        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(d2);
        sb.append("')");
        return sb.toString();
    }
}
