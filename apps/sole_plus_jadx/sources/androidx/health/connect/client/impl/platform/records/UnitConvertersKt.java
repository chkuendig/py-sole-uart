package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.units.BloodGlucose;
import android.health.connect.datatypes.units.Energy;
import android.health.connect.datatypes.units.Length;
import android.health.connect.datatypes.units.Mass;
import android.health.connect.datatypes.units.Percentage;
import android.health.connect.datatypes.units.Power;
import android.health.connect.datatypes.units.Pressure;
import android.health.connect.datatypes.units.Temperature;
import android.health.connect.datatypes.units.Velocity;
import android.health.connect.datatypes.units.Volume;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnitConverters.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00060\u0006j\u0002`\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00060\tj\u0002`\n*\u00020\u000bH\u0000\u001a\u0010\u0010\f\u001a\u00060\u0002j\u0002`\u0003*\u00020\u0001H\u0000\u001a\u0010\u0010\r\u001a\u00060\u000ej\u0002`\u000f*\u00020\u0010H\u0000\u001a\u0010\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00020\u0005H\u0000\u001a\u0010\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014*\u00020\u0015H\u0000\u001a\u0010\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018*\u00020\u0019H\u0000\u001a\u0010\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c*\u00020\u001dH\u0000\u001a\u0010\u0010\u001e\u001a\u00060\u001fj\u0002` *\u00020!H\u0000\u001a\u0010\u0010\"\u001a\u00060#j\u0002`$*\u00020%H\u0000\u001a\u0010\u0010&\u001a\u00060'j\u0002`(*\u00020)H\u0000\u001a\u0010\u0010*\u001a\u00020\u000b*\u00060\tj\u0002`\nH\u0000\u001a\u0010\u0010+\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u0010\u0010,\u001a\u00020\u0010*\u00060\u000ej\u0002`\u000fH\u0000\u001a\u0010\u0010-\u001a\u00020\u0005*\u00060\u0006j\u0002`\u0007H\u0000\u001a\u0010\u0010.\u001a\u00020\u0015*\u00060\u0013j\u0002`\u0014H\u0000\u001a\u0010\u0010/\u001a\u00020\u0019*\u00060\u0017j\u0002`\u0018H\u0000\u001a\u0010\u00100\u001a\u00020\u001d*\u00060\u001bj\u0002`\u001cH\u0000\u001a\u0010\u00101\u001a\u00020!*\u00060\u001fj\u0002` H\u0000\u001a\u0010\u00102\u001a\u00020%*\u00060#j\u0002`$H\u0000\u001a\u0010\u00103\u001a\u00020)*\u00060'j\u0002`(H\u0000¨\u00064"}, d2 = {"toNonDefaultSdkEnergy", "Landroidx/health/connect/client/units/Energy;", "Landroid/health/connect/datatypes/units/Energy;", "Landroidx/health/connect/client/impl/platform/records/PlatformEnergy;", "toNonDefaultSdkMass", "Landroidx/health/connect/client/units/Mass;", "Landroid/health/connect/datatypes/units/Mass;", "Landroidx/health/connect/client/impl/platform/records/PlatformMass;", "toPlatformBloodGlucose", "Landroid/health/connect/datatypes/units/BloodGlucose;", "Landroidx/health/connect/client/impl/platform/records/PlatformBloodGlucose;", "Landroidx/health/connect/client/units/BloodGlucose;", "toPlatformEnergy", "toPlatformLength", "Landroid/health/connect/datatypes/units/Length;", "Landroidx/health/connect/client/impl/platform/records/PlatformLength;", "Landroidx/health/connect/client/units/Length;", "toPlatformMass", "toPlatformPercentage", "Landroid/health/connect/datatypes/units/Percentage;", "Landroidx/health/connect/client/impl/platform/records/PlatformPercentage;", "Landroidx/health/connect/client/units/Percentage;", "toPlatformPower", "Landroid/health/connect/datatypes/units/Power;", "Landroidx/health/connect/client/impl/platform/records/PlatformPower;", "Landroidx/health/connect/client/units/Power;", "toPlatformPressure", "Landroid/health/connect/datatypes/units/Pressure;", "Landroidx/health/connect/client/impl/platform/records/PlatformPressure;", "Landroidx/health/connect/client/units/Pressure;", "toPlatformTemperature", "Landroid/health/connect/datatypes/units/Temperature;", "Landroidx/health/connect/client/impl/platform/records/PlatformTemperature;", "Landroidx/health/connect/client/units/Temperature;", "toPlatformVelocity", "Landroid/health/connect/datatypes/units/Velocity;", "Landroidx/health/connect/client/impl/platform/records/PlatformVelocity;", "Landroidx/health/connect/client/units/Velocity;", "toPlatformVolume", "Landroid/health/connect/datatypes/units/Volume;", "Landroidx/health/connect/client/impl/platform/records/PlatformVolume;", "Landroidx/health/connect/client/units/Volume;", "toSdkBloodGlucose", "toSdkEnergy", "toSdkLength", "toSdkMass", "toSdkPercentage", "toSdkPower", "toSdkPressure", "toSdkTemperature", "toSdkVelocity", "toSdkVolume", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UnitConvertersKt {
    public static final BloodGlucose toPlatformBloodGlucose(androidx.health.connect.client.units.BloodGlucose bloodGlucose) {
        Intrinsics.checkNotNullParameter(bloodGlucose, "<this>");
        BloodGlucose bloodGlucoseFromMillimolesPerLiter = BloodGlucose.fromMillimolesPerLiter(bloodGlucose.getMillimolesPerLiter());
        Intrinsics.checkNotNullExpressionValue(bloodGlucoseFromMillimolesPerLiter, "fromMillimolesPerLiter(inMillimolesPerLiter)");
        return bloodGlucoseFromMillimolesPerLiter;
    }

    public static final Energy toPlatformEnergy(androidx.health.connect.client.units.Energy energy) {
        Intrinsics.checkNotNullParameter(energy, "<this>");
        Energy energyFromCalories = Energy.fromCalories(energy.getCalories());
        Intrinsics.checkNotNullExpressionValue(energyFromCalories, "fromCalories(inCalories)");
        return energyFromCalories;
    }

    public static final Length toPlatformLength(androidx.health.connect.client.units.Length length) {
        Intrinsics.checkNotNullParameter(length, "<this>");
        Length lengthFromMeters = Length.fromMeters(length.getMeters());
        Intrinsics.checkNotNullExpressionValue(lengthFromMeters, "fromMeters(inMeters)");
        return lengthFromMeters;
    }

    public static final Mass toPlatformMass(androidx.health.connect.client.units.Mass mass) {
        Intrinsics.checkNotNullParameter(mass, "<this>");
        Mass massFromGrams = Mass.fromGrams(mass.getGrams());
        Intrinsics.checkNotNullExpressionValue(massFromGrams, "fromGrams(inGrams)");
        return massFromGrams;
    }

    public static final Percentage toPlatformPercentage(androidx.health.connect.client.units.Percentage percentage) {
        Intrinsics.checkNotNullParameter(percentage, "<this>");
        Percentage percentageFromValue = Percentage.fromValue(percentage.getValue());
        Intrinsics.checkNotNullExpressionValue(percentageFromValue, "fromValue(value)");
        return percentageFromValue;
    }

    public static final Power toPlatformPower(androidx.health.connect.client.units.Power power) {
        Intrinsics.checkNotNullParameter(power, "<this>");
        Power powerFromWatts = Power.fromWatts(power.getWatts());
        Intrinsics.checkNotNullExpressionValue(powerFromWatts, "fromWatts(inWatts)");
        return powerFromWatts;
    }

    public static final Pressure toPlatformPressure(androidx.health.connect.client.units.Pressure pressure) {
        Intrinsics.checkNotNullParameter(pressure, "<this>");
        Pressure pressureFromMillimetersOfMercury = Pressure.fromMillimetersOfMercury(pressure.getValue());
        Intrinsics.checkNotNullExpressionValue(pressureFromMillimetersOfMercury, "fromMillimetersOfMercury(inMillimetersOfMercury)");
        return pressureFromMillimetersOfMercury;
    }

    public static final Temperature toPlatformTemperature(androidx.health.connect.client.units.Temperature temperature) {
        Intrinsics.checkNotNullParameter(temperature, "<this>");
        Temperature temperatureFromCelsius = Temperature.fromCelsius(temperature.getCelsius());
        Intrinsics.checkNotNullExpressionValue(temperatureFromCelsius, "fromCelsius(inCelsius)");
        return temperatureFromCelsius;
    }

    public static final Velocity toPlatformVelocity(androidx.health.connect.client.units.Velocity velocity) {
        Intrinsics.checkNotNullParameter(velocity, "<this>");
        Velocity velocityFromMetersPerSecond = Velocity.fromMetersPerSecond(velocity.getMetersPerSecond());
        Intrinsics.checkNotNullExpressionValue(velocityFromMetersPerSecond, "fromMetersPerSecond(inMetersPerSecond)");
        return velocityFromMetersPerSecond;
    }

    public static final Volume toPlatformVolume(androidx.health.connect.client.units.Volume volume) {
        Intrinsics.checkNotNullParameter(volume, "<this>");
        Volume volumeFromLiters = Volume.fromLiters(volume.getLiters());
        Intrinsics.checkNotNullExpressionValue(volumeFromLiters, "fromLiters(inLiters)");
        return volumeFromLiters;
    }

    public static final androidx.health.connect.client.units.BloodGlucose toSdkBloodGlucose(BloodGlucose bloodGlucose) {
        Intrinsics.checkNotNullParameter(bloodGlucose, "<this>");
        return androidx.health.connect.client.units.BloodGlucose.INSTANCE.millimolesPerLiter(bloodGlucose.getInMillimolesPerLiter());
    }

    public static final androidx.health.connect.client.units.Energy toNonDefaultSdkEnergy(Energy energy) {
        Intrinsics.checkNotNullParameter(energy, "<this>");
        if (energy.getInCalories() == Double.MIN_VALUE) {
            energy = null;
        }
        if (energy != null) {
            return toSdkEnergy(energy);
        }
        return null;
    }

    public static final androidx.health.connect.client.units.Energy toSdkEnergy(Energy energy) {
        Intrinsics.checkNotNullParameter(energy, "<this>");
        return androidx.health.connect.client.units.Energy.INSTANCE.calories(energy.getInCalories());
    }

    public static final androidx.health.connect.client.units.Length toSdkLength(Length length) {
        Intrinsics.checkNotNullParameter(length, "<this>");
        return androidx.health.connect.client.units.Length.INSTANCE.meters(length.getInMeters());
    }

    public static final androidx.health.connect.client.units.Mass toNonDefaultSdkMass(Mass mass) {
        Intrinsics.checkNotNullParameter(mass, "<this>");
        if (mass.getInGrams() == Double.MIN_VALUE) {
            mass = null;
        }
        if (mass != null) {
            return toSdkMass(mass);
        }
        return null;
    }

    public static final androidx.health.connect.client.units.Mass toSdkMass(Mass mass) {
        Intrinsics.checkNotNullParameter(mass, "<this>");
        return androidx.health.connect.client.units.Mass.INSTANCE.grams(mass.getInGrams());
    }

    public static final androidx.health.connect.client.units.Percentage toSdkPercentage(Percentage percentage) {
        Intrinsics.checkNotNullParameter(percentage, "<this>");
        return new androidx.health.connect.client.units.Percentage(percentage.getValue());
    }

    public static final androidx.health.connect.client.units.Power toSdkPower(Power power) {
        Intrinsics.checkNotNullParameter(power, "<this>");
        return androidx.health.connect.client.units.Power.INSTANCE.watts(power.getInWatts());
    }

    public static final androidx.health.connect.client.units.Pressure toSdkPressure(Pressure pressure) {
        Intrinsics.checkNotNullParameter(pressure, "<this>");
        return androidx.health.connect.client.units.Pressure.INSTANCE.millimetersOfMercury(pressure.getInMillimetersOfMercury());
    }

    public static final androidx.health.connect.client.units.Temperature toSdkTemperature(Temperature temperature) {
        Intrinsics.checkNotNullParameter(temperature, "<this>");
        return androidx.health.connect.client.units.Temperature.INSTANCE.celsius(temperature.getInCelsius());
    }

    public static final androidx.health.connect.client.units.Velocity toSdkVelocity(Velocity velocity) {
        Intrinsics.checkNotNullParameter(velocity, "<this>");
        return androidx.health.connect.client.units.Velocity.INSTANCE.metersPerSecond(velocity.getInMetersPerSecond());
    }

    public static final androidx.health.connect.client.units.Volume toSdkVolume(Volume volume) {
        Intrinsics.checkNotNullParameter(volume, "<this>");
        return androidx.health.connect.client.units.Volume.INSTANCE.liters(volume.getInLiters());
    }
}
