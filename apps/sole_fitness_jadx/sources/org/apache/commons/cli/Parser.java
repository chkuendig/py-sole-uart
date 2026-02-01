package org.apache.commons.cli;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

/* loaded from: classes2.dex */
public abstract class Parser implements CommandLineParser {
    protected CommandLine cmd;
    private Options options;
    private List requiredOptions;

    protected abstract String[] flatten(Options options, String[] strArr, boolean z);

    protected void setOptions(Options options) {
        this.options = options;
        this.requiredOptions = new ArrayList(options.getRequiredOptions());
    }

    protected Options getOptions() {
        return this.options;
    }

    protected List getRequiredOptions() {
        return this.requiredOptions;
    }

    @Override // org.apache.commons.cli.CommandLineParser
    public CommandLine parse(Options options, String[] strArr) throws ParseException {
        return parse(options, strArr, null, false);
    }

    public CommandLine parse(Options options, String[] strArr, Properties properties) throws ParseException {
        return parse(options, strArr, properties, false);
    }

    @Override // org.apache.commons.cli.CommandLineParser
    public CommandLine parse(Options options, String[] strArr, boolean z) throws ParseException {
        return parse(options, strArr, null, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CommandLine parse(Options options, String[] strArr, Properties properties, boolean z) throws ParseException {
        Iterator it = options.helpOptions().iterator();
        while (it.hasNext()) {
            ((Option) it.next()).clearValues();
        }
        setOptions(options);
        this.cmd = new CommandLine();
        boolean z2 = false;
        if (strArr == null) {
            strArr = new String[0];
        }
        ListIterator listIterator = Arrays.asList(flatten(getOptions(), strArr, z)).listIterator();
        while (listIterator.hasNext()) {
            String str = (String) listIterator.next();
            if (!HelpFormatter.DEFAULT_LONG_OPT_PREFIX.equals(str)) {
                if (HelpFormatter.DEFAULT_OPT_PREFIX.equals(str)) {
                    if (z) {
                        z2 = true;
                    } else {
                        this.cmd.addArg(str);
                    }
                } else if (str.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX)) {
                    if (z && !getOptions().hasOption(str)) {
                        this.cmd.addArg(str);
                        z2 = true;
                    } else {
                        processOption(str, listIterator);
                    }
                } else {
                    this.cmd.addArg(str);
                    if (z) {
                    }
                }
            }
            if (z2) {
                while (listIterator.hasNext()) {
                    String str2 = (String) listIterator.next();
                    if (!HelpFormatter.DEFAULT_LONG_OPT_PREFIX.equals(str2)) {
                        this.cmd.addArg(str2);
                    }
                }
            }
        }
        processProperties(properties);
        checkRequiredOptions();
        return this.cmd;
    }

    protected void processProperties(Properties properties) {
        if (properties == null) {
            return;
        }
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String string = enumerationPropertyNames.nextElement().toString();
            if (!this.cmd.hasOption(string)) {
                Option option = getOptions().getOption(string);
                String property = properties.getProperty(string);
                if (option.hasArg()) {
                    if (option.getValues() == null || option.getValues().length == 0) {
                        try {
                            option.addValueForProcessing(property);
                        } catch (RuntimeException unused) {
                        }
                    }
                } else if (!"yes".equalsIgnoreCase(property) && !ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(property) && !AppEventsConstants.EVENT_PARAM_VALUE_YES.equalsIgnoreCase(property)) {
                    return;
                }
                this.cmd.addOption(option);
            }
        }
    }

    protected void checkRequiredOptions() throws MissingOptionException {
        if (!getRequiredOptions().isEmpty()) {
            throw new MissingOptionException(getRequiredOptions());
        }
    }

    public void processArgs(Option option, ListIterator listIterator) throws ParseException {
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            String str = (String) listIterator.next();
            if (getOptions().hasOption(str) && str.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX)) {
                listIterator.previous();
                break;
            } else {
                try {
                    option.addValueForProcessing(Util.stripLeadingAndTrailingQuotes(str));
                } catch (RuntimeException unused) {
                    listIterator.previous();
                }
            }
        }
        if (option.getValues() == null && !option.hasOptionalArg()) {
            throw new MissingArgumentException(option);
        }
    }

    protected void processOption(String str, ListIterator listIterator) throws ParseException {
        if (!getOptions().hasOption(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unrecognized option: ");
            stringBuffer.append(str);
            throw new UnrecognizedOptionException(stringBuffer.toString(), str);
        }
        Option option = (Option) getOptions().getOption(str).clone();
        if (option.isRequired()) {
            getRequiredOptions().remove(option.getKey());
        }
        if (getOptions().getOptionGroup(option) != null) {
            OptionGroup optionGroup = getOptions().getOptionGroup(option);
            if (optionGroup.isRequired()) {
                getRequiredOptions().remove(optionGroup);
            }
            optionGroup.setSelected(option);
        }
        if (option.hasArg()) {
            processArgs(option, listIterator);
        }
        this.cmd.addOption(option);
    }
}
