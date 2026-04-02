package com.google.crypto.tink.prf;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class PrfSetWrapper implements PrimitiveWrapper<PrfSet> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class WrappedPrfSet extends PrfSet {
        private final Map<Integer, Prf> keyIdToPrfMap;
        private final int primaryKeyId;

        private WrappedPrfSet(PrimitiveSet<PrfSet> primitiveSet) {
            if (primitiveSet.getRawPrimitives().isEmpty()) {
                throw new GeneralSecurityException("No primitives provided.");
            }
            if (primitiveSet.getPrimary() == null) {
                throw new GeneralSecurityException("Primary key not set.");
            }
            this.primaryKeyId = primitiveSet.getPrimary().getKeyId();
            List<PrimitiveSet.Entry<PrfSet>> rawPrimitives = primitiveSet.getRawPrimitives();
            HashMap hashMap = new HashMap();
            for (PrimitiveSet.Entry<PrfSet> entry : rawPrimitives) {
                if (!entry.getOutputPrefixType().equals(OutputPrefixType.RAW)) {
                    throw new GeneralSecurityException("Key " + entry.getKeyId() + " has non raw prefix type");
                } else if (entry.getPrimitive().getPrfs().size() > 1) {
                    throw new GeneralSecurityException("More PRFs than expected in KeyTypeManager for key " + entry.getKeyId());
                } else {
                    hashMap.put(Integer.valueOf(entry.getKeyId()), entry.getPrimitive().getPrfs().get(Integer.valueOf(entry.getPrimitive().getPrimaryId())));
                }
            }
            this.keyIdToPrfMap = Collections.unmodifiableMap(hashMap);
        }

        @Override // com.google.crypto.tink.prf.PrfSet
        public Map<Integer, Prf> getPrfs() {
            return this.keyIdToPrfMap;
        }

        @Override // com.google.crypto.tink.prf.PrfSet
        public int getPrimaryId() {
            return this.primaryKeyId;
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(new PrfSetWrapper());
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<PrfSet> getPrimitiveClass() {
        return PrfSet.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public PrfSet wrap(PrimitiveSet<PrfSet> primitiveSet) {
        return new WrappedPrfSet(primitiveSet);
    }
}
