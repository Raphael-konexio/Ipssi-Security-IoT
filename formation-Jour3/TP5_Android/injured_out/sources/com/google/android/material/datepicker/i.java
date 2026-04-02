package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.t;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public final class i<S> extends androidx.fragment.app.c {
    static final Object F0 = "CONFIRM_BUTTON_TAG";
    static final Object G0 = "CANCEL_BUTTON_TAG";
    static final Object H0 = "TOGGLE_BUTTON_TAG";
    private boolean A0;
    private TextView B0;
    private CheckableImageButton C0;
    private b.c.a.b.a0.g D0;
    private Button E0;
    private final LinkedHashSet<j<? super S>> p0 = new LinkedHashSet<>();
    private final LinkedHashSet<View.OnClickListener> q0 = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnCancelListener> r0 = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> s0 = new LinkedHashSet<>();
    private int t0;
    private com.google.android.material.datepicker.d<S> u0;
    private p<S> v0;
    private com.google.android.material.datepicker.a w0;
    private h<S> x0;
    private int y0;
    private CharSequence z0;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = i.this.p0.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(i.this.N1());
            }
            i.this.s1();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = i.this.q0.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            i.this.s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements o<S> {
        c() {
        }

        @Override // com.google.android.material.datepicker.o
        public void a(S s) {
            Button button;
            boolean z;
            i.this.T1();
            if (i.this.u0.i()) {
                button = i.this.E0;
                z = true;
            } else {
                button = i.this.E0;
                z = false;
            }
            button.setEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.C0.toggle();
            i iVar = i.this;
            iVar.U1(iVar.C0);
            i.this.R1();
        }
    }

    private static Drawable J1(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, a.a.k.a.a.d(context, b.c.a.b.e.ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], a.a.k.a.a.d(context, b.c.a.b.e.ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int K1(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(b.c.a.b.d.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(b.c.a.b.d.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(b.c.a.b.d.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(b.c.a.b.d.mtrl_calendar_days_of_week_height);
        return dimensionPixelSize + dimensionPixelSize2 + (m.j * resources.getDimensionPixelSize(b.c.a.b.d.mtrl_calendar_day_height)) + ((m.j - 1) * resources.getDimensionPixelOffset(b.c.a.b.d.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(b.c.a.b.d.mtrl_calendar_bottom_padding);
    }

    private static int M1(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(b.c.a.b.d.mtrl_calendar_content_padding);
        int i = l.F().j;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(b.c.a.b.d.mtrl_calendar_day_width) * i) + ((i - 1) * resources.getDimensionPixelOffset(b.c.a.b.d.mtrl_calendar_month_horizontal_padding));
    }

    private int O1(Context context) {
        int i = this.t0;
        return i != 0 ? i : this.u0.e(context);
    }

    private void P1(Context context) {
        this.C0.setTag(H0);
        this.C0.setImageDrawable(J1(context));
        a.g.k.s.f0(this.C0, null);
        U1(this.C0);
        this.C0.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Q1(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(b.c.a.b.x.b.c(context, b.c.a.b.b.materialCalendarStyle, h.class.getCanonicalName()), new int[]{16843277});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1() {
        this.x0 = h.H1(this.u0, O1(d1()), this.w0);
        this.v0 = this.C0.isChecked() ? k.s1(this.u0, this.w0) : this.x0;
        T1();
        t i = q().i();
        i.o(b.c.a.b.f.mtrl_calendar_frame, this.v0);
        i.j();
        this.v0.q1(new c());
    }

    public static long S1() {
        return l.F().l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1() {
        String L1 = L1();
        this.B0.setContentDescription(String.format(K(b.c.a.b.i.mtrl_picker_announce_current_selection), L1));
        this.B0.setText(L1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1(CheckableImageButton checkableImageButton) {
        this.C0.setContentDescription(checkableImageButton.getContext().getString(this.C0.isChecked() ? b.c.a.b.i.mtrl_picker_toggle_to_calendar_input_mode : b.c.a.b.i.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void A0(Bundle bundle) {
        super.A0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.t0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.u0);
        a.b bVar = new a.b(this.w0);
        if (this.x0.D1() != null) {
            bVar.b(this.x0.D1().l);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.y0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.z0);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void B0() {
        super.B0();
        Window window = x1().getWindow();
        if (this.A0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.D0);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = E().getDimensionPixelOffset(b.c.a.b.d.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.D0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new b.c.a.b.r.a(x1(), rect));
        }
        R1();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void C0() {
        this.v0.r1();
        super.C0();
    }

    public String L1() {
        return this.u0.d(r());
    }

    public final S N1() {
        return this.u0.m();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void e0(Bundle bundle) {
        super.e0(bundle);
        if (bundle == null) {
            bundle = p();
        }
        this.t0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.u0 = (com.google.android.material.datepicker.d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.w0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.y0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.z0 = bundle.getCharSequence("TITLE_TEXT_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.A0 ? b.c.a.b.h.mtrl_picker_fullscreen : b.c.a.b.h.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.A0) {
            inflate.findViewById(b.c.a.b.f.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(M1(context), -2));
        } else {
            View findViewById = inflate.findViewById(b.c.a.b.f.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(b.c.a.b.f.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(M1(context), -1));
            findViewById2.setMinimumHeight(K1(d1()));
        }
        TextView textView = (TextView) inflate.findViewById(b.c.a.b.f.mtrl_picker_header_selection_text);
        this.B0 = textView;
        a.g.k.s.h0(textView, 1);
        this.C0 = (CheckableImageButton) inflate.findViewById(b.c.a.b.f.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(b.c.a.b.f.mtrl_picker_title_text);
        CharSequence charSequence = this.z0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.y0);
        }
        P1(context);
        this.E0 = (Button) inflate.findViewById(b.c.a.b.f.confirm_button);
        if (this.u0.i()) {
            this.E0.setEnabled(true);
        } else {
            this.E0.setEnabled(false);
        }
        this.E0.setTag(F0);
        this.E0.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(b.c.a.b.f.cancel_button);
        button.setTag(G0);
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.r0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.s0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) N();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.c
    public final Dialog w1(Bundle bundle) {
        Dialog dialog = new Dialog(d1(), O1(d1()));
        Context context = dialog.getContext();
        this.A0 = Q1(context);
        int c2 = b.c.a.b.x.b.c(context, b.c.a.b.b.colorSurface, i.class.getCanonicalName());
        b.c.a.b.a0.g gVar = new b.c.a.b.a0.g(context, null, b.c.a.b.b.materialCalendarStyle, b.c.a.b.j.Widget_MaterialComponents_MaterialCalendar);
        this.D0 = gVar;
        gVar.L(context);
        this.D0.T(ColorStateList.valueOf(c2));
        this.D0.S(a.g.k.s.r(dialog.getWindow().getDecorView()));
        return dialog;
    }
}
