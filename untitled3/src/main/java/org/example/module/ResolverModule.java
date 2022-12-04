package org.example.module;

import dagger.Module;
import dagger.Provides;
import org.example.entity.Context;
import org.example.entity.Controller;
import org.example.entity.Resolver;

@Module
public class ResolverModule {

    @Provides
    public static Resolver resolver(Context context, Controller controller) {
        return new Resolver(context, controller);
    }

    @Provides
    public static Controller controller(Context context) {
        return new Controller(context);
    }
}
