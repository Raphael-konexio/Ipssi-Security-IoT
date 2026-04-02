package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
/* loaded from: classes.dex */
final class x {

    /* renamed from: a  reason: collision with root package name */
    private TextView f659a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f660b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TextView textView) {
        a.g.j.i.c(textView);
        this.f659a = textView;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f660b;
        if (textClassifier == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) this.f659a.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
        return textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f660b = textClassifier;
    }
}
