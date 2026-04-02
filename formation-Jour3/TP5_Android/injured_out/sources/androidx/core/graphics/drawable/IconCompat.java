package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f755a;

    /* renamed from: b  reason: collision with root package name */
    Object f756b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f757c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f758d;
    public int e;
    public int f;
    public ColorStateList g;
    PorterDuff.Mode h;
    public String i;
    public String j;

    public IconCompat() {
        this.f755a = -1;
        this.f757c = null;
        this.f758d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = k;
        this.i = null;
    }

    private IconCompat(int i) {
        this.f755a = -1;
        this.f757c = null;
        this.f758d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = k;
        this.i = null;
        this.f755a = i;
    }

    static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat b(Resources resources, String str, int i) {
        if (str != null) {
            if (i != 0) {
                IconCompat iconCompat = new IconCompat(2);
                iconCompat.e = i;
                if (resources != null) {
                    try {
                        iconCompat.f756b = resources.getResourceName(i);
                    } catch (Resources.NotFoundException unused) {
                        throw new IllegalArgumentException("Icon resource cannot be found");
                    }
                } else {
                    iconCompat.f756b = str;
                }
                iconCompat.j = str;
                return iconCompat;
            }
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        throw new IllegalArgumentException("Package must not be null.");
    }

    private static int d(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    private static String f(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    private static int h(Icon icon) {
        StringBuilder sb;
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            Log.e("IconCompat", sb.toString(), e);
            return -1;
        } catch (NoSuchMethodException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            Log.e("IconCompat", sb.toString(), e);
            return -1;
        } catch (InvocationTargetException e3) {
            e = e3;
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            Log.e("IconCompat", sb.toString(), e);
            return -1;
        }
    }

    private static Uri j(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon uri", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        }
    }

    private static String p(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int c() {
        if (this.f755a != -1 || Build.VERSION.SDK_INT < 23) {
            if (this.f755a == 2) {
                return this.e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        return d((Icon) this.f756b);
    }

    public String e() {
        if (this.f755a != -1 || Build.VERSION.SDK_INT < 23) {
            if (this.f755a == 2) {
                return TextUtils.isEmpty(this.j) ? ((String) this.f756b).split(":", -1)[0] : this.j;
            }
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return f((Icon) this.f756b);
    }

    public int g() {
        return (this.f755a != -1 || Build.VERSION.SDK_INT < 23) ? this.f755a : h((Icon) this.f756b);
    }

    public Uri i() {
        if (this.f755a != -1 || Build.VERSION.SDK_INT < 23) {
            int i = this.f755a;
            if (i == 4 || i == 6) {
                return Uri.parse((String) this.f756b);
            }
            throw new IllegalStateException("called getUri() on " + this);
        }
        return j((Icon) this.f756b);
    }

    public InputStream k(Context context) {
        StringBuilder sb;
        String str;
        Uri i = i();
        String scheme = i.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(i);
            } catch (Exception e) {
                e = e;
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f756b));
            } catch (FileNotFoundException e2) {
                e = e2;
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
            }
        }
        sb.append(str);
        sb.append(i);
        Log.w("IconCompat", sb.toString(), e);
        return null;
    }

    public void l() {
        Parcelable parcelable;
        this.h = PorterDuff.Mode.valueOf(this.i);
        switch (this.f755a) {
            case -1:
                parcelable = this.f758d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                parcelable = this.f758d;
                if (parcelable == null) {
                    byte[] bArr = this.f757c;
                    this.f756b = bArr;
                    this.f755a = 3;
                    this.e = 0;
                    this.f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f757c, Charset.forName("UTF-16"));
                this.f756b = str;
                if (this.f755a == 2 && this.j == null) {
                    this.j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f756b = this.f757c;
                return;
        }
        this.f756b = parcelable;
    }

    public void m(boolean z) {
        this.i = this.h.name();
        switch (this.f755a) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f756b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f757c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f757c = ((String) this.f756b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f757c = (byte[]) this.f756b;
                return;
            case 4:
            case 6:
                this.f757c = this.f756b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f758d = (Parcelable) this.f756b;
    }

    @Deprecated
    public Icon n() {
        return o(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r0 >= 26) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.drawable.Icon o(android.content.Context r5) {
        /*
            r4 = this;
            int r0 = r4.f755a
            r1 = 0
            r2 = 26
            switch(r0) {
                case -1: goto Lb7;
                case 0: goto L8;
                case 1: goto L9e;
                case 2: goto L93;
                case 3: goto L86;
                case 4: goto L7d;
                case 5: goto L67;
                case 6: goto L10;
                default: goto L8;
            }
        L8:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unknown type"
            r5.<init>(r0)
            throw r5
        L10:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r0 < r3) goto L20
            android.net.Uri r5 = r4.i()
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithAdaptiveBitmapContentUri(r5)
            goto La6
        L20:
            if (r5 == 0) goto L4c
            java.io.InputStream r5 = r4.k(r5)
            if (r5 == 0) goto L31
            int r0 = android.os.Build.VERSION.SDK_INT
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)
            if (r0 < r2) goto L78
            goto L6f
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot load adaptive icon from uri: "
            r0.append(r1)
            android.net.Uri r1 = r4.i()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L4c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
            r0.append(r1)
            android.net.Uri r1 = r4.i()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L67:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L74
            java.lang.Object r5 = r4.f756b
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
        L6f:
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithAdaptiveBitmap(r5)
            goto La6
        L74:
            java.lang.Object r5 = r4.f756b
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
        L78:
            android.graphics.Bitmap r5 = a(r5, r1)
            goto La2
        L7d:
            java.lang.Object r5 = r4.f756b
            java.lang.String r5 = (java.lang.String) r5
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithContentUri(r5)
            goto La6
        L86:
            java.lang.Object r5 = r4.f756b
            byte[] r5 = (byte[]) r5
            int r0 = r4.e
            int r1 = r4.f
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithData(r5, r0, r1)
            goto La6
        L93:
            java.lang.String r5 = r4.e()
            int r0 = r4.e
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithResource(r5, r0)
            goto La6
        L9e:
            java.lang.Object r5 = r4.f756b
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
        La2:
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithBitmap(r5)
        La6:
            android.content.res.ColorStateList r0 = r4.g
            if (r0 == 0) goto Lad
            r5.setTintList(r0)
        Lad:
            android.graphics.PorterDuff$Mode r0 = r4.h
            android.graphics.PorterDuff$Mode r1 = androidx.core.graphics.drawable.IconCompat.k
            if (r0 == r1) goto Lb6
            r5.setTintMode(r0)
        Lb6:
            return r5
        Lb7:
            java.lang.Object r5 = r4.f756b
            android.graphics.drawable.Icon r5 = (android.graphics.drawable.Icon) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.o(android.content.Context):android.graphics.drawable.Icon");
    }

    public String toString() {
        int height;
        if (this.f755a == -1) {
            return String.valueOf(this.f756b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(p(this.f755a));
        switch (this.f755a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f756b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f756b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f != 0) {
                    sb.append(" off=");
                    height = this.f;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f756b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.h != k) {
            sb.append(" mode=");
            sb.append(this.h);
        }
        sb.append(")");
        return sb.toString();
    }
}
