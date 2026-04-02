package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import com.google.crypto.tink.shaded.protobuf.Reader;
import io.flutter.embedding.engine.i.c;
import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final io.flutter.embedding.engine.i.c f2428a;

    /* renamed from: b  reason: collision with root package name */
    private int f2429b;

    /* renamed from: c  reason: collision with root package name */
    private C0113a f2430c;

    /* renamed from: io.flutter.embedding.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0113a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final Deque<KeyEvent> f2431a = new ArrayDeque();

        /* renamed from: b  reason: collision with root package name */
        private final View f2432b;

        /* renamed from: c  reason: collision with root package name */
        private final io.flutter.plugin.editing.d f2433c;

        public C0113a(View view, io.flutter.plugin.editing.d dVar) {
            this.f2432b = view;
            this.f2433c = dVar;
        }

        private KeyEvent f(KeyEvent keyEvent) {
            if (this.f2431a.size() == 0) {
                throw new AssertionError("Event response received when no events are in the queue. Received event " + keyEvent);
            } else if (this.f2431a.getFirst() == keyEvent) {
                return this.f2431a.getFirst();
            } else {
                throw new AssertionError("Event response received out of order. Should have seen event " + this.f2431a.getFirst() + " first. Instead, received " + keyEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g(KeyEvent keyEvent) {
            return this.f2431a.size() > 0 && this.f2431a.getFirst() == keyEvent;
        }

        private void h(KeyEvent keyEvent) {
            if (this.f2433c.n().isAcceptingText() && this.f2433c.o() != null && this.f2433c.o().sendKeyEvent(keyEvent)) {
                i();
                return;
            }
            View view = this.f2432b;
            if (view != null) {
                view.getRootView().dispatchKeyEvent(keyEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public KeyEvent i() {
            return this.f2431a.removeFirst();
        }

        @Override // io.flutter.embedding.engine.i.c.a
        public void a(KeyEvent keyEvent) {
            i();
        }

        @Override // io.flutter.embedding.engine.i.c.a
        public void b(KeyEvent keyEvent) {
            h(f(keyEvent));
        }

        public void e(KeyEvent keyEvent) {
            this.f2431a.addLast(keyEvent);
            if (this.f2431a.size() > 1000) {
                c.a.b.b("AndroidKeyProcessor", "There are " + this.f2431a.size() + " keyboard events that have not yet received a response. Are responses being sent?");
            }
        }
    }

    public a(View view, io.flutter.embedding.engine.i.c cVar, io.flutter.plugin.editing.d dVar) {
        this.f2428a = cVar;
        dVar.A(this);
        C0113a c0113a = new C0113a(view, dVar);
        this.f2430c = c0113a;
        this.f2428a.f(c0113a);
    }

    private Character a(int i) {
        if (i == 0) {
            return null;
        }
        char c2 = (char) i;
        if ((Integer.MIN_VALUE & i) != 0) {
            int i2 = i & Reader.READ_DONE;
            int i3 = this.f2429b;
            if (i3 != 0) {
                i2 = KeyCharacterMap.getDeadChar(i3, i2);
            }
            this.f2429b = i2;
        } else {
            int i4 = this.f2429b;
            if (i4 != 0) {
                int deadChar = KeyCharacterMap.getDeadChar(i4, i);
                if (deadChar > 0) {
                    c2 = (char) deadChar;
                }
                this.f2429b = 0;
            }
        }
        return Character.valueOf(c2);
    }

    public void b() {
        this.f2428a.f(null);
    }

    public boolean c(KeyEvent keyEvent) {
        return this.f2430c.g(keyEvent);
    }

    public boolean d(KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (action == 0 || action == 1) {
            if (this.f2430c.g(keyEvent)) {
                this.f2430c.i();
                return false;
            }
            c.b bVar = new c.b(keyEvent, a(keyEvent.getUnicodeChar()));
            this.f2430c.e(keyEvent);
            io.flutter.embedding.engine.i.c cVar = this.f2428a;
            if (action == 0) {
                cVar.c(bVar);
            } else {
                cVar.d(bVar);
            }
            return true;
        }
        return false;
    }
}
