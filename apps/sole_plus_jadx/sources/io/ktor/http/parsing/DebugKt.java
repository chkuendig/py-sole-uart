package io.ktor.http.parsing;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: Debug.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\b"}, d2 = {"printlnWithOffset", "", "offset", "", "node", "", "printDebug", "Lio/ktor/http/parsing/Grammar;", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DebugKt {
    public static /* synthetic */ void printDebug$default(Grammar grammar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        printDebug(grammar, i);
    }

    public static final void printDebug(Grammar grammar, int i) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        if (grammar instanceof StringGrammar) {
            printlnWithOffset(i, "STRING[" + Regex.INSTANCE.escape(((StringGrammar) grammar).getValue()) + AbstractJsonLexerKt.END_LIST);
            return;
        }
        if (grammar instanceof RawGrammar) {
            printlnWithOffset(i, "STRING[" + ((RawGrammar) grammar).getValue() + AbstractJsonLexerKt.END_LIST);
            return;
        }
        if (grammar instanceof NamedGrammar) {
            NamedGrammar namedGrammar = (NamedGrammar) grammar;
            printlnWithOffset(i, "NAMED[" + namedGrammar.getName() + AbstractJsonLexerKt.END_LIST);
            printDebug(namedGrammar.getGrammar(), i + 2);
            return;
        }
        if (grammar instanceof SequenceGrammar) {
            printlnWithOffset(i, "SEQUENCE");
            Iterator<T> it = ((SequenceGrammar) grammar).getGrammars().iterator();
            while (it.hasNext()) {
                printDebug((Grammar) it.next(), i + 2);
            }
            return;
        }
        if (grammar instanceof OrGrammar) {
            printlnWithOffset(i, "OR");
            Iterator<T> it2 = ((OrGrammar) grammar).getGrammars().iterator();
            while (it2.hasNext()) {
                printDebug((Grammar) it2.next(), i + 2);
            }
            return;
        }
        if (grammar instanceof MaybeGrammar) {
            printlnWithOffset(i, "MAYBE");
            printDebug(((MaybeGrammar) grammar).getGrammar(), i + 2);
            return;
        }
        if (grammar instanceof ManyGrammar) {
            printlnWithOffset(i, "MANY");
            printDebug(((ManyGrammar) grammar).getGrammar(), i + 2);
            return;
        }
        if (grammar instanceof AtLeastOne) {
            printlnWithOffset(i, "MANY_NOT_EMPTY");
            printDebug(((AtLeastOne) grammar).getGrammar(), i + 2);
        } else if (grammar instanceof AnyOfGrammar) {
            printlnWithOffset(i, "ANY_OF[" + Regex.INSTANCE.escape(((AnyOfGrammar) grammar).getValue()) + AbstractJsonLexerKt.END_LIST);
        } else {
            if (!(grammar instanceof RangeGrammar)) {
                throw new NoWhenBranchMatchedException();
            }
            RangeGrammar rangeGrammar = (RangeGrammar) grammar;
            printlnWithOffset(i, "RANGE[" + rangeGrammar.getFrom() + SignatureVisitor.SUPER + rangeGrammar.getTo() + AbstractJsonLexerKt.END_LIST);
        }
    }

    private static final void printlnWithOffset(int i, Object obj) {
        System.out.println((Object) (StringsKt.repeat(" ", i) + (i / 2) + ": " + obj));
    }
}
