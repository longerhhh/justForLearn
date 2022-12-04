package org.example.component;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import org.example.Main;
import org.example.entity.Context;
import org.example.entity.OverlayPlugin;
import org.example.module.ResolverModule;

@Component(modules = {ResolverModule.class})
public interface ResolverComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        ResolverComponent build();
    }

    Context provideContext();

    public void inject(OverlayPlugin plugin);
}

