package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class SearchView extends i0 implements a.a.n.c {
    static final k v0 = new k();
    final ImageView A;
    final ImageView B;
    private final View C;
    private p D;
    private Rect E;
    private Rect F;
    private int[] G;
    private int[] H;
    private final ImageView I;
    private final Drawable J;
    private final int K;
    private final int L;
    private final Intent M;
    private final Intent N;
    private final CharSequence O;
    private m P;
    private l Q;
    View.OnFocusChangeListener R;
    private n S;
    private View.OnClickListener T;
    private boolean U;
    private boolean V;
    a.h.a.a W;
    private boolean a0;
    private CharSequence b0;
    private boolean c0;
    private boolean d0;
    private int e0;
    private boolean f0;
    private CharSequence g0;
    private CharSequence h0;
    private boolean i0;
    private int j0;
    SearchableInfo k0;
    private Bundle l0;
    private final Runnable m0;
    private Runnable n0;
    private final WeakHashMap<String, Drawable.ConstantState> o0;
    private final View.OnClickListener p0;
    View.OnKeyListener q0;
    private final TextView.OnEditorActionListener r0;
    private final AdapterView.OnItemClickListener s0;
    private final AdapterView.OnItemSelectedListener t0;
    final SearchAutoComplete u;
    private TextWatcher u0;
    private final View v;
    private final View w;
    private final View x;
    final ImageView y;
    final ImageView z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends androidx.appcompat.widget.d {
        private int i;
        private SearchView j;
        private boolean k;
        final Runnable l;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.b();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, a.a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.l = new a();
            this.i = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i < 960 || i2 < 720 || configuration.orientation != 2) {
                if (i < 600) {
                    return (i < 640 || i2 < 480) ? 160 : 192;
                }
                return 192;
            }
            return 256;
        }

        boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void b() {
            if (this.k) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.k = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.i <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.k) {
                removeCallbacks(this.l);
                post(this.l);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.j.Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.j.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.j.hasFocus() && getVisibility() == 0) {
                this.k = true;
                if (SearchView.M(getContext())) {
                    SearchView.v0.c(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.k = false;
                removeCallbacks(this.l);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (!inputMethodManager.isActive(this)) {
                this.k = true;
            } else {
                this.k = false;
                removeCallbacks(this.l);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.j = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.i = i;
        }
    }

    /* loaded from: classes.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.Y(charSequence);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.f0();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.h.a.a aVar = SearchView.this.W;
            if (aVar instanceof q0) {
                aVar.a(null);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.R;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.this.B();
        }
    }

    /* loaded from: classes.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.y) {
                searchView.V();
            } else if (view == searchView.A) {
                searchView.R();
            } else if (view == searchView.z) {
                searchView.W();
            } else if (view == searchView.B) {
                searchView.a0();
            } else if (view == searchView.u) {
                searchView.H();
            }
        }
    }

    /* loaded from: classes.dex */
    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.k0 == null) {
                return false;
            }
            if (!searchView.u.isPopupShowing() || SearchView.this.u.getListSelection() == -1) {
                if (!SearchView.this.u.a() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i == 66) {
                    view.cancelLongPress();
                    SearchView searchView2 = SearchView.this;
                    searchView2.P(0, null, searchView2.u.getText().toString());
                    return true;
                }
                return false;
            }
            return SearchView.this.X(view, i, keyEvent);
        }
    }

    /* loaded from: classes.dex */
    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.S(i, 0, null);
        }
    }

    /* loaded from: classes.dex */
    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.T(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        private Method f574a;

        /* renamed from: b  reason: collision with root package name */
        private Method f575b;

        /* renamed from: c  reason: collision with root package name */
        private Method f576c;

        k() {
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f574a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f575b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f576c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f575b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f574a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView, boolean z) {
            Method method = this.f576c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        boolean b();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean a(String str);

        boolean b(String str);
    }

    /* loaded from: classes.dex */
    public interface n {
        boolean a(int i);

        boolean b(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class o extends a.i.a.a {
        public static final Parcelable.Creator<o> CREATOR = new a();
        boolean h;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<o> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public o createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public o[] newArray(int i) {
                return new o[i];
            }
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.h = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.h + "}";
        }

        @Override // a.i.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.h));
        }
    }

    /* loaded from: classes.dex */
    private static class p extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f577a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f578b;

        /* renamed from: c  reason: collision with root package name */
        private final Rect f579c;

        /* renamed from: d  reason: collision with root package name */
        private final Rect f580d;
        private final int e;
        private boolean f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f578b = new Rect();
            this.f580d = new Rect();
            this.f579c = new Rect();
            a(rect, rect2);
            this.f577a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f578b.set(rect);
            this.f580d.set(rect);
            Rect rect3 = this.f580d;
            int i = this.e;
            rect3.inset(-i, -i);
            this.f579c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            float f;
            int i;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f;
                    if (z2 && !this.f580d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f;
                        this.f = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else {
                if (this.f578b.contains(x, y)) {
                    this.f = true;
                    z = true;
                }
                z = true;
                z3 = false;
            }
            if (z3) {
                if (!z || this.f579c.contains(x, y)) {
                    Rect rect = this.f579c;
                    f = x - rect.left;
                    i = y - rect.top;
                } else {
                    f = this.f577a.getWidth() / 2;
                    i = this.f577a.getHeight() / 2;
                }
                motionEvent.setLocation(f, i);
                return this.f577a.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.E = new Rect();
        this.F = new Rect();
        this.G = new int[2];
        this.H = new int[2];
        this.m0 = new b();
        this.n0 = new c();
        this.o0 = new WeakHashMap<>();
        this.p0 = new f();
        this.q0 = new g();
        this.r0 = new h();
        this.s0 = new i();
        this.t0 = new j();
        this.u0 = new a();
        w0 u = w0.u(context, attributeSet, a.a.j.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(u.n(a.a.j.SearchView_layout, a.a.g.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(a.a.f.search_src_text);
        this.u = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.v = findViewById(a.a.f.search_edit_frame);
        this.w = findViewById(a.a.f.search_plate);
        this.x = findViewById(a.a.f.submit_area);
        this.y = (ImageView) findViewById(a.a.f.search_button);
        this.z = (ImageView) findViewById(a.a.f.search_go_btn);
        this.A = (ImageView) findViewById(a.a.f.search_close_btn);
        this.B = (ImageView) findViewById(a.a.f.search_voice_btn);
        this.I = (ImageView) findViewById(a.a.f.search_mag_icon);
        a.g.k.s.i0(this.w, u.g(a.a.j.SearchView_queryBackground));
        a.g.k.s.i0(this.x, u.g(a.a.j.SearchView_submitBackground));
        this.y.setImageDrawable(u.g(a.a.j.SearchView_searchIcon));
        this.z.setImageDrawable(u.g(a.a.j.SearchView_goIcon));
        this.A.setImageDrawable(u.g(a.a.j.SearchView_closeIcon));
        this.B.setImageDrawable(u.g(a.a.j.SearchView_voiceIcon));
        this.I.setImageDrawable(u.g(a.a.j.SearchView_searchIcon));
        this.J = u.g(a.a.j.SearchView_searchHintIcon);
        y0.a(this.y, getResources().getString(a.a.h.abc_searchview_description_search));
        this.K = u.n(a.a.j.SearchView_suggestionRowLayout, a.a.g.abc_search_dropdown_item_icons_2line);
        this.L = u.n(a.a.j.SearchView_commitIcon, 0);
        this.y.setOnClickListener(this.p0);
        this.A.setOnClickListener(this.p0);
        this.z.setOnClickListener(this.p0);
        this.B.setOnClickListener(this.p0);
        this.u.setOnClickListener(this.p0);
        this.u.addTextChangedListener(this.u0);
        this.u.setOnEditorActionListener(this.r0);
        this.u.setOnItemClickListener(this.s0);
        this.u.setOnItemSelectedListener(this.t0);
        this.u.setOnKeyListener(this.q0);
        this.u.setOnFocusChangeListener(new d());
        setIconifiedByDefault(u.a(a.a.j.SearchView_iconifiedByDefault, true));
        int f2 = u.f(a.a.j.SearchView_android_maxWidth, -1);
        if (f2 != -1) {
            setMaxWidth(f2);
        }
        this.O = u.p(a.a.j.SearchView_defaultQueryHint);
        this.b0 = u.p(a.a.j.SearchView_queryHint);
        int k2 = u.k(a.a.j.SearchView_android_imeOptions, -1);
        if (k2 != -1) {
            setImeOptions(k2);
        }
        int k3 = u.k(a.a.j.SearchView_android_inputType, -1);
        if (k3 != -1) {
            setInputType(k3);
        }
        setFocusable(u.a(a.a.j.SearchView_android_focusable, true));
        u.v();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.M = intent;
        intent.addFlags(268435456);
        this.M.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.N = intent2;
        intent2.addFlags(268435456);
        View findViewById = findViewById(this.u.getDropDownAnchor());
        this.C = findViewById;
        if (findViewById != null) {
            findViewById.addOnLayoutChangeListener(new e());
        }
        k0(this.U);
        g0();
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.h0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.l0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.k0.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i2, String str) {
        int i3;
        String o2;
        try {
            String o3 = q0.o(cursor, "suggest_intent_action");
            if (o3 == null) {
                o3 = this.k0.getSuggestIntentAction();
            }
            if (o3 == null) {
                o3 = "android.intent.action.SEARCH";
            }
            String str2 = o3;
            String o4 = q0.o(cursor, "suggest_intent_data");
            if (o4 == null) {
                o4 = this.k0.getSuggestIntentData();
            }
            if (o4 != null && (o2 = q0.o(cursor, "suggest_intent_data_id")) != null) {
                o4 = o4 + "/" + Uri.encode(o2);
            }
            return C(str2, o4 == null ? null : Uri.parse(o4), q0.o(cursor, "suggest_intent_extra_data"), q0.o(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.l0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.u.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.G);
        getLocationInWindow(this.H);
        int[] iArr = this.G;
        int i2 = iArr[1];
        int[] iArr2 = this.H;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.U || this.J == null) {
            return charSequence;
        }
        int textSize = (int) (this.u.getTextSize() * 1.25d);
        this.J.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.J), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        SearchableInfo searchableInfo = this.k0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.k0.getVoiceSearchLaunchWebSearch()) {
            intent = this.M;
        } else if (this.k0.getVoiceSearchLaunchRecognizer()) {
            intent = this.N;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean N() {
        return (this.a0 || this.f0) && !L();
    }

    private void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    private boolean Q(int i2, int i3, String str) {
        Cursor b2 = this.W.b();
        if (b2 == null || !b2.moveToPosition(i2)) {
            return false;
        }
        O(D(b2, i3, str));
        return true;
    }

    private void b0() {
        post(this.m0);
    }

    private void c0(int i2) {
        CharSequence c2;
        Editable text = this.u.getText();
        Cursor b2 = this.W.b();
        if (b2 == null) {
            return;
        }
        if (!b2.moveToPosition(i2) || (c2 = this.W.c(b2)) == null) {
            setQuery(text);
        } else {
            setQuery(c2);
        }
    }

    private void e0() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.u.getText());
        if (!z2 && (!this.U || this.i0)) {
            z = false;
        }
        this.A.setVisibility(z ? 0 : 8);
        Drawable drawable = this.A.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.u;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(a.a.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(a.a.d.abc_search_view_preferred_width);
    }

    private void h0() {
        this.u.setThreshold(this.k0.getSuggestThreshold());
        this.u.setImeOptions(this.k0.getImeOptions());
        int inputType = this.k0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.k0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.u.setInputType(inputType);
        a.h.a.a aVar = this.W;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.k0.getSuggestAuthority() != null) {
            q0 q0Var = new q0(getContext(), this, this.k0, this.o0);
            this.W = q0Var;
            this.u.setAdapter(q0Var);
            ((q0) this.W).x(this.c0 ? 2 : 1);
        }
    }

    private void i0() {
        this.x.setVisibility((N() && (this.z.getVisibility() == 0 || this.B.getVisibility() == 0)) ? 0 : 8);
    }

    private void j0(boolean z) {
        this.z.setVisibility((this.a0 && N() && hasFocus() && (z || !this.f0)) ? 0 : 8);
    }

    private void k0(boolean z) {
        this.V = z;
        int i2 = 0;
        int i3 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.u.getText());
        this.y.setVisibility(i3);
        j0(z2);
        this.v.setVisibility(z ? 8 : 0);
        this.I.setVisibility((this.I.getDrawable() == null || this.U) ? 8 : 8);
        e0();
        l0(!z2);
        i0();
    }

    private void l0(boolean z) {
        int i2 = 8;
        if (this.f0 && !L() && z) {
            this.z.setVisibility(8);
            i2 = 0;
        }
        this.B.setVisibility(i2);
    }

    private void setQuery(CharSequence charSequence) {
        this.u.setText(charSequence);
        this.u.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void B() {
        if (this.C.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.w.getPaddingLeft();
            Rect rect = new Rect();
            boolean b2 = c1.b(this);
            int dimensionPixelSize = this.U ? resources.getDimensionPixelSize(a.a.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(a.a.d.abc_dropdownitem_text_padding_left) : 0;
            this.u.getDropDownBackground().getPadding(rect);
            int i2 = rect.left;
            this.u.setDropDownHorizontalOffset(b2 ? -i2 : paddingLeft - (i2 + dimensionPixelSize));
            this.u.setDropDownWidth((((this.C.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.u.refreshAutoCompleteResults();
            return;
        }
        v0.b(this.u);
        v0.a(this.u);
    }

    public boolean L() {
        return this.V;
    }

    void P(int i2, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i2, str));
    }

    void R() {
        if (!TextUtils.isEmpty(this.u.getText())) {
            this.u.setText("");
            this.u.requestFocus();
            this.u.setImeVisibility(true);
        } else if (this.U) {
            l lVar = this.Q;
            if (lVar == null || !lVar.b()) {
                clearFocus();
                k0(true);
            }
        }
    }

    boolean S(int i2, int i3, String str) {
        n nVar = this.S;
        if (nVar == null || !nVar.b(i2)) {
            Q(i2, 0, null);
            this.u.setImeVisibility(false);
            G();
            return true;
        }
        return false;
    }

    boolean T(int i2) {
        n nVar = this.S;
        if (nVar == null || !nVar.a(i2)) {
            c0(i2);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void V() {
        k0(false);
        this.u.requestFocus();
        this.u.setImeVisibility(true);
        View.OnClickListener onClickListener = this.T;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void W() {
        Editable text = this.u.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        m mVar = this.P;
        if (mVar == null || !mVar.b(text.toString())) {
            if (this.k0 != null) {
                P(0, null, text.toString());
            }
            this.u.setImeVisibility(false);
            G();
        }
    }

    boolean X(View view, int i2, KeyEvent keyEvent) {
        if (this.k0 != null && this.W != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return S(this.u.getListSelection(), 0, null);
            }
            if (i2 == 21 || i2 == 22) {
                this.u.setSelection(i2 == 21 ? 0 : this.u.length());
                this.u.setListSelection(0);
                this.u.clearListSelection();
                v0.c(this.u, true);
                return true;
            } else if (i2 != 19 || this.u.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    void Y(CharSequence charSequence) {
        Editable text = this.u.getText();
        this.h0 = text;
        boolean z = !TextUtils.isEmpty(text);
        j0(z);
        l0(!z);
        e0();
        i0();
        if (this.P != null && !TextUtils.equals(charSequence, this.g0)) {
            this.P.a(charSequence.toString());
        }
        this.g0 = charSequence.toString();
    }

    void Z() {
        k0(L());
        b0();
        if (this.u.hasFocus()) {
            H();
        }
    }

    void a0() {
        Intent E;
        SearchableInfo searchableInfo = this.k0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                E = F(this.M, searchableInfo);
            } else if (!searchableInfo.getVoiceSearchLaunchRecognizer()) {
                return;
            } else {
                E = E(this.N, searchableInfo);
            }
            getContext().startActivity(E);
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    @Override // a.a.n.c
    public void c() {
        if (this.i0) {
            return;
        }
        this.i0 = true;
        int imeOptions = this.u.getImeOptions();
        this.j0 = imeOptions;
        this.u.setImeOptions(imeOptions | 33554432);
        this.u.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.d0 = true;
        super.clearFocus();
        this.u.clearFocus();
        this.u.setImeVisibility(false);
        this.d0 = false;
    }

    public void d0(CharSequence charSequence, boolean z) {
        this.u.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.u;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.h0 = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        W();
    }

    @Override // a.a.n.c
    public void f() {
        d0("", false);
        clearFocus();
        k0(true);
        this.u.setImeOptions(this.j0);
        this.i0 = false;
    }

    void f0() {
        int[] iArr = this.u.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.w.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.x.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.u.getImeOptions();
    }

    public int getInputType() {
        return this.u.getInputType();
    }

    public int getMaxWidth() {
        return this.e0;
    }

    public CharSequence getQuery() {
        return this.u.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.b0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.k0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.O : getContext().getText(this.k0.getHintId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.K;
    }

    public a.h.a.a getSuggestionsAdapter() {
        return this.W;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.m0);
        post(this.n0);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            I(this.u, this.E);
            Rect rect = this.F;
            Rect rect2 = this.E;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            p pVar = this.D;
            if (pVar != null) {
                pVar.a(this.F, this.E);
                return;
            }
            p pVar2 = new p(this.F, this.E, this.u);
            this.D = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r0 <= 0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    @Override // androidx.appcompat.widget.i0, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.L()
            if (r0 == 0) goto La
            super.onMeasure(r4, r5)
            return
        La:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L2c
            if (r0 == 0) goto L22
            if (r0 == r2) goto L1d
            goto L39
        L1d:
            int r0 = r3.e0
            if (r0 <= 0) goto L39
            goto L30
        L22:
            int r4 = r3.e0
            if (r4 <= 0) goto L27
            goto L39
        L27:
            int r4 = r3.getPreferredWidth()
            goto L39
        L2c:
            int r0 = r3.e0
            if (r0 <= 0) goto L31
        L30:
            goto L35
        L31:
            int r0 = r3.getPreferredWidth()
        L35:
            int r4 = java.lang.Math.min(r0, r4)
        L39:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L4b
            if (r0 == 0) goto L46
            goto L53
        L46:
            int r5 = r3.getPreferredHeight()
            goto L53
        L4b:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L53:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.a());
        k0(oVar.h);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.h = L();
        return oVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (!this.d0 && isFocusable()) {
            if (L()) {
                return super.requestFocus(i2, rect);
            }
            boolean requestFocus = this.u.requestFocus(i2, rect);
            if (requestFocus) {
                k0(false);
            }
            return requestFocus;
        }
        return false;
    }

    public void setAppSearchData(Bundle bundle) {
        this.l0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.U == z) {
            return;
        }
        this.U = z;
        k0(z);
        g0();
    }

    public void setImeOptions(int i2) {
        this.u.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.u.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.e0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
        this.Q = lVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.R = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.P = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.T = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
        this.S = nVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.b0 = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.c0 = z;
        a.h.a.a aVar = this.W;
        if (aVar instanceof q0) {
            ((q0) aVar).x(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.k0 = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean K = K();
        this.f0 = K;
        if (K) {
            this.u.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.a0 = z;
        k0(L());
    }

    public void setSuggestionsAdapter(a.h.a.a aVar) {
        this.W = aVar;
        this.u.setAdapter(aVar);
    }
}
