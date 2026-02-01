package com.android.builder.testing.api;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
public interface DeviceConfig {

    public enum Category {
        CONFIG,
        ABI
    }

    List<String> getAbis();

    String getConfigFor(String str);

    String getConfigForAllAbis();

    Optional<String> getValue(Category category);

    public static class Builder {

        private static class Values {
            private final Category myCategory;
            private final String value;

            private Values(Category category, String str) {
                this.myCategory = category;
                this.value = str;
            }
        }

        public static DeviceConfig parse(Collection<String> collection) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String str : collection) {
                for (Category category : Category.values()) {
                    String str2 = category.name().toLowerCase(Locale.US) + ": ";
                    if (str.startsWith(str2)) {
                        builder.add((ImmutableList.Builder) new Values(category, str.substring(str2.length())));
                    }
                }
            }
            final ImmutableList immutableListBuild = builder.build();
            return new DeviceConfig() { // from class: com.android.builder.testing.api.DeviceConfig.Builder.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.android.builder.testing.api.DeviceConfig
                public Optional<String> getValue(Category category2) {
                    UnmodifiableIterator it = immutableListBuild.iterator();
                    while (it.hasNext()) {
                        Values values = (Values) it.next();
                        if (values.myCategory.equals(category2)) {
                            return Optional.of(values.value);
                        }
                    }
                    return Optional.empty();
                }

                @Override // com.android.builder.testing.api.DeviceConfig
                public List<String> getAbis() {
                    ImmutableList.Builder builder2 = ImmutableList.builder();
                    Optional<String> value = getValue(Category.ABI);
                    if (value.isPresent()) {
                        StringTokenizer stringTokenizer = new StringTokenizer(value.get(), ",");
                        while (stringTokenizer.hasMoreElements()) {
                            builder2.add((ImmutableList.Builder) stringTokenizer.nextToken());
                        }
                    }
                    return builder2.build();
                }

                @Override // com.android.builder.testing.api.DeviceConfig
                public String getConfigForAllAbis() {
                    StringBuilder sb = new StringBuilder();
                    Optional<String> value = getValue(Category.CONFIG);
                    List<String> abis = getAbis();
                    if (abis.isEmpty() && value.isPresent()) {
                        sb.append(value.get());
                    } else {
                        if (value.isPresent()) {
                            sb.append(value.get());
                            sb.append(":");
                        }
                        Joiner.on(",").appendTo(sb, (Iterable<? extends Object>) abis);
                    }
                    return sb.toString();
                }

                @Override // com.android.builder.testing.api.DeviceConfig
                public String getConfigFor(String str3) {
                    StringBuilder sb = new StringBuilder();
                    Optional<String> value = getValue(Category.CONFIG);
                    if (value.isPresent()) {
                        sb.append(value.get());
                        if (!Strings.isNullOrEmpty(str3)) {
                            sb.append(":");
                        }
                    }
                    if (!Strings.isNullOrEmpty(str3)) {
                        sb.append(str3);
                    }
                    return sb.toString();
                }
            };
        }
    }
}
