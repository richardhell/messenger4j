package com.github.messenger4j.internal.gson;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

import com.github.messenger4j.messengerprofile.MessengerSettings;
import com.github.messenger4j.send.message.Message;
import com.github.messenger4j.send.message.richmedia.RichMediaAsset;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Optional;

/**
 * @author Andriy Koretskyy
 * @author Max Grabenhorst
 * @since 1.0.0
 */
public final class GsonFactory {

    private GsonFactory() {
    }

    public static Gson createGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapterFactory(new LowercaseEnumTypeAdapterFactory())
                .registerTypeAdapter(Optional.class, new OptionalSerializer())
                .registerTypeAdapter(Float.class, new FloatSerializer())
                .registerTypeAdapter(Message.class, new MessageSerializer())
                .registerTypeAdapter(RichMediaAsset.class, new RichMediaAssetSerializer())
                .registerTypeAdapter(MessengerSettings.class, new MessengerSettingsSerializer())
                .create();
    }

}
