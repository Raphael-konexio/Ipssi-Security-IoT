package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import io.flutter.embedding.android.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FlutterSplashView extends FrameLayout {
    private static String o = "FlutterSplashView";
    private n f;
    private j g;
    private View h;
    private Bundle i;
    private String j;
    private String k;
    private final j.d l;
    private final io.flutter.embedding.engine.renderer.b m;
    private final Runnable n;

    @Keep
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static Parcelable.Creator<SavedState> CREATOR = new a();
        private String previousCompletedSplashIsolate;
        private Bundle splashScreenState;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(SavedState.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
        }
    }

    /* loaded from: classes.dex */
    class a implements j.d {
        a() {
        }

        @Override // io.flutter.embedding.android.j.d
        public void a() {
        }

        @Override // io.flutter.embedding.android.j.d
        public void b(io.flutter.embedding.engine.a aVar) {
            FlutterSplashView.this.g.s(this);
            FlutterSplashView flutterSplashView = FlutterSplashView.this;
            flutterSplashView.g(flutterSplashView.g, FlutterSplashView.this.f);
        }
    }

    /* loaded from: classes.dex */
    class b implements io.flutter.embedding.engine.renderer.b {
        b() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void d() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void g() {
            if (FlutterSplashView.this.f != null) {
                FlutterSplashView.this.k();
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FlutterSplashView flutterSplashView = FlutterSplashView.this;
            flutterSplashView.removeView(flutterSplashView.h);
            FlutterSplashView flutterSplashView2 = FlutterSplashView.this;
            flutterSplashView2.k = flutterSplashView2.j;
        }
    }

    public FlutterSplashView(Context context) {
        this(context, null, 0);
    }

    public FlutterSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new a();
        this.m = new b();
        this.n = new c();
        setSaveEnabled(true);
    }

    private boolean h() {
        j jVar = this.g;
        if (jVar != null) {
            if (jVar.r()) {
                return this.g.getAttachedFlutterEngine().h().g() != null && this.g.getAttachedFlutterEngine().h().g().equals(this.k);
            }
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
        throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
    }

    private boolean i() {
        j jVar = this.g;
        return (jVar == null || !jVar.r() || this.g.p() || h()) ? false : true;
    }

    private boolean j() {
        n nVar;
        j jVar = this.g;
        return jVar != null && jVar.r() && (nVar = this.f) != null && nVar.b() && l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j = this.g.getAttachedFlutterEngine().h().g();
        String str = o;
        c.a.b.d(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.j);
        this.f.a(this.n);
    }

    private boolean l() {
        j jVar = this.g;
        if (jVar != null) {
            if (jVar.r()) {
                return this.g.p() && !h();
            }
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
        throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
    }

    public void g(j jVar, n nVar) {
        j jVar2 = this.g;
        if (jVar2 != null) {
            jVar2.t(this.m);
            removeView(this.g);
        }
        View view = this.h;
        if (view != null) {
            removeView(view);
        }
        this.g = jVar;
        addView(jVar);
        this.f = nVar;
        if (nVar != null) {
            if (i()) {
                c.a.b.d(o, "Showing splash screen UI.");
                View c2 = nVar.c(getContext(), this.i);
                this.h = c2;
                addView(c2);
                jVar.h(this.m);
            } else if (!j()) {
                if (jVar.r()) {
                    return;
                }
                c.a.b.d(o, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
                jVar.g(this.l);
            } else {
                c.a.b.d(o, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
                View c3 = nVar.c(getContext(), this.i);
                this.h = c3;
                addView(c3);
                k();
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.k = savedState.previousCompletedSplashIsolate;
        this.i = savedState.splashScreenState;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.previousCompletedSplashIsolate = this.k;
        n nVar = this.f;
        savedState.splashScreenState = nVar != null ? nVar.d() : null;
        return savedState;
    }
}
