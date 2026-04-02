package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.navigation.d;
import androidx.navigation.h;
import androidx.navigation.o;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f946c = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private Context f947a;

    /* renamed from: b  reason: collision with root package name */
    private s f948b;

    public n(Context context, s sVar) {
        this.f947a = context;
        this.f948b = sVar;
    }

    private static p a(TypedValue typedValue, p pVar, p pVar2, String str, String str2) {
        if (pVar == null || pVar == pVar2) {
            return pVar != null ? pVar : pVar2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    private j b(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) {
        int depth;
        j a2 = this.f948b.e(xmlResourceParser.getName()).a();
        a2.y(this.f947a, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    g(resources, a2, attributeSet, i);
                } else if ("deepLink".equals(name)) {
                    h(resources, a2, attributeSet);
                } else if ("action".equals(name)) {
                    d(resources, a2, attributeSet, xmlResourceParser, i);
                } else if ("include".equals(name) && (a2 instanceof k)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, u.NavInclude);
                    ((k) a2).E(c(obtainAttributes.getResourceId(u.NavInclude_graph, 0)));
                    obtainAttributes.recycle();
                } else if (a2 instanceof k) {
                    ((k) a2).E(b(resources, xmlResourceParser, attributeSet, i));
                }
            }
        }
        return a2;
    }

    private void d(Resources resources, j jVar, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i) {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.v.a.NavAction);
        int resourceId = obtainAttributes.getResourceId(androidx.navigation.v.a.NavAction_android_id, 0);
        c cVar = new c(obtainAttributes.getResourceId(androidx.navigation.v.a.NavAction_destination, 0));
        o.a aVar = new o.a();
        aVar.d(obtainAttributes.getBoolean(androidx.navigation.v.a.NavAction_launchSingleTop, false));
        aVar.g(obtainAttributes.getResourceId(androidx.navigation.v.a.NavAction_popUpTo, -1), obtainAttributes.getBoolean(androidx.navigation.v.a.NavAction_popUpToInclusive, false));
        aVar.b(obtainAttributes.getResourceId(androidx.navigation.v.a.NavAction_enterAnim, -1));
        aVar.c(obtainAttributes.getResourceId(androidx.navigation.v.a.NavAction_exitAnim, -1));
        aVar.e(obtainAttributes.getResourceId(androidx.navigation.v.a.NavAction_popEnterAnim, -1));
        aVar.f(obtainAttributes.getResourceId(androidx.navigation.v.a.NavAction_popExitAnim, -1));
        cVar.b(aVar.a());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && "argument".equals(xmlResourceParser.getName())) {
                f(resources, bundle, attributeSet, i);
            }
        }
        if (!bundle.isEmpty()) {
            cVar.a(bundle);
        }
        jVar.z(resourceId, cVar);
        obtainAttributes.recycle();
    }

    private d e(TypedArray typedArray, Resources resources, int i) {
        float f;
        int dimension;
        d.a aVar = new d.a();
        aVar.c(typedArray.getBoolean(androidx.navigation.v.a.NavArgument_nullable, false));
        TypedValue typedValue = f946c.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f946c.set(typedValue);
        }
        String string = typedArray.getString(androidx.navigation.v.a.NavArgument_argType);
        Object obj = null;
        p<Integer> a2 = string != null ? p.a(string, resources.getResourcePackageName(i)) : null;
        if (typedArray.getValue(androidx.navigation.v.a.NavArgument_android_defaultValue, typedValue)) {
            p<Integer> pVar = p.f958c;
            if (a2 == pVar) {
                dimension = typedValue.resourceId;
                if (dimension == 0) {
                    if (typedValue.type != 16 || typedValue.data != 0) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + a2.c() + ". Must be a reference to a resource.");
                    }
                    obj = 0;
                }
                obj = Integer.valueOf(dimension);
            } else {
                int i2 = typedValue.resourceId;
                if (i2 != 0) {
                    if (a2 != null) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + a2.c() + ". You must use a \"" + p.f958c.c() + "\" type to reference other resources.");
                    }
                    a2 = pVar;
                    obj = Integer.valueOf(i2);
                } else if (a2 == p.k) {
                    obj = typedArray.getString(androidx.navigation.v.a.NavArgument_android_defaultValue);
                } else {
                    int i3 = typedValue.type;
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                a2 = a(typedValue, a2, p.f957b, string, "dimension");
                                dimension = (int) typedValue.getDimension(resources.getDisplayMetrics());
                            } else if (i3 == 18) {
                                a2 = a(typedValue, a2, p.i, string, "boolean");
                                obj = Boolean.valueOf(typedValue.data != 0);
                            } else if (i3 < 16 || i3 > 31) {
                                throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                            } else {
                                p<Float> pVar2 = p.g;
                                if (a2 == pVar2) {
                                    a2 = a(typedValue, a2, pVar2, string, "float");
                                    f = typedValue.data;
                                } else {
                                    a2 = a(typedValue, a2, p.f957b, string, "integer");
                                    dimension = typedValue.data;
                                }
                            }
                            obj = Integer.valueOf(dimension);
                        } else {
                            a2 = a(typedValue, a2, p.g, string, "float");
                            f = typedValue.getFloat();
                        }
                        obj = Float.valueOf(f);
                    } else {
                        String charSequence = typedValue.string.toString();
                        if (a2 == null) {
                            a2 = p.d(charSequence);
                        }
                        obj = a2.h(charSequence);
                    }
                }
            }
        }
        if (obj != null) {
            aVar.b(obj);
        }
        if (a2 != null) {
            aVar.d(a2);
        }
        return aVar.a();
    }

    private void f(Resources resources, Bundle bundle, AttributeSet attributeSet, int i) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.v.a.NavArgument);
        String string = obtainAttributes.getString(androidx.navigation.v.a.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        d e = e(obtainAttributes, resources, i);
        if (e.b()) {
            e.c(string, bundle);
        }
        obtainAttributes.recycle();
    }

    private void g(Resources resources, j jVar, AttributeSet attributeSet, int i) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.v.a.NavArgument);
        String string = obtainAttributes.getString(androidx.navigation.v.a.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        jVar.d(string, e(obtainAttributes, resources, i));
        obtainAttributes.recycle();
    }

    private void h(Resources resources, j jVar, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.v.a.NavDeepLink);
        String string = obtainAttributes.getString(androidx.navigation.v.a.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(androidx.navigation.v.a.NavDeepLink_action);
        String string3 = obtainAttributes.getString(androidx.navigation.v.a.NavDeepLink_mimeType);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        h.a aVar = new h.a();
        if (string != null) {
            aVar.d(string.replace("${applicationId}", this.f947a.getPackageName()));
        }
        if (!TextUtils.isEmpty(string2)) {
            aVar.b(string2.replace("${applicationId}", this.f947a.getPackageName()));
        }
        if (string3 != null) {
            aVar.c(string3.replace("${applicationId}", this.f947a.getPackageName()));
        }
        jVar.e(aVar.a());
        obtainAttributes.recycle();
    }

    public k c(int i) {
        int next;
        Resources resources = this.f947a.getResources();
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        while (true) {
            try {
                try {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i) + " line " + xml.getLineNumber(), e);
                }
            } finally {
                xml.close();
            }
        }
        if (next == 2) {
            String name = xml.getName();
            j b2 = b(resources, xml, asAttributeSet, i);
            if (b2 instanceof k) {
                return (k) b2;
            }
            throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
        }
        throw new XmlPullParserException("No start tag found");
    }
}
