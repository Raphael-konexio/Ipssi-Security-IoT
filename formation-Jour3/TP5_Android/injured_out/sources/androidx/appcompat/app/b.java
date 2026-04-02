package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
/* loaded from: classes.dex */
public class b extends g implements DialogInterface {
    final AlertController h;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.f f487a;

        /* renamed from: b  reason: collision with root package name */
        private final int f488b;

        public a(Context context) {
            this(context, b.i(context, 0));
        }

        public a(Context context, int i) {
            this.f487a = new AlertController.f(new ContextThemeWrapper(context, b.i(context, i)));
            this.f488b = i;
        }

        public b a() {
            b bVar = new b(this.f487a.f481a, this.f488b);
            this.f487a.a(bVar.h);
            bVar.setCancelable(this.f487a.r);
            if (this.f487a.r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f487a.s);
            bVar.setOnDismissListener(this.f487a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f487a.u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        public Context b() {
            return this.f487a.f481a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f487a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f487a.g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f487a.f484d = drawable;
            return this;
        }

        public a f(DialogInterface.OnKeyListener onKeyListener) {
            this.f487a.u = onKeyListener;
            return this;
        }

        public a g(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f487a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            fVar.I = i;
            fVar.H = true;
            return this;
        }

        public a h(CharSequence charSequence) {
            this.f487a.f = charSequence;
            return this;
        }
    }

    protected b(Context context, int i) {
        super(context, i(context, i));
        this.h = new AlertController(getContext(), this, getWindow());
    }

    static int i(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView h() {
        return this.h.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.h.g(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.h.h(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.h.q(charSequence);
    }
}
