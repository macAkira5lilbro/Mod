package com.example.thesixsevenmod;

import com.example.thesixsevenmod.block.ModBlocks;
import com.example.thesixsevenmod.item.ModCreativeModeTabs;
import com.example.thesixsevenmod.item.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.example.thesixsevenmod.item.ModItems.ITEMS;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TheSixSevenMod.MODID)
public class TheSixSevenMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "thesixsevenmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "thesixsevenmod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public TheSixSevenMod(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (TheSixSevenMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);


        ModCreativeModeTabs.register(modEventBus);
        ModBlocks.register(modEventBus);

        ITEMS.register(modEventBus);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        NeoForge.EVENT_BUS.addListener(this::onPlayerTick);

        NeoForge.EVENT_BUS.addListener(TheSixSevenMod::onPlayerDamage);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static void onPlayerDamage(LivingIncomingDamageEvent event) {
        if (event.isCanceled()) return;

        if(event.getEntity() instanceof Player player){
            ItemStack charm = player.getOffhandItem();
            EquipmentSlot slot = EquipmentSlot.OFFHAND;
            if(!charm.is(ModItems.CHARM_OF_RESILIENCE.get())){
                charm = player.getMainHandItem();
                slot =  EquipmentSlot.MAINHAND;
            }
            if(!charm.is(ModItems.CHARM_OF_RESILIENCE.get())){
                return;
            }
            float chance = player.getRandom().nextFloat();
            if(chance <= 0.2f){

                event.setCanceled(true);
                player.invulnerableTime = Math.max(player.invulnerableTime, 30);
            }
            player.level().playSound(
                    null,
                    player.blockPosition(),
                    SoundEvents.SHIELD_BLOCK,
                    SoundSource.PLAYERS,
                    1.0f, 1.0f
            );
            charm.hurtAndBreak(1, player, slot);
        }
    }

    private void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player instanceof ServerPlayer serverPlayer) {

            ItemStack offhand = serverPlayer.getOffhandItem();
            EquipmentSlot slot = EquipmentSlot.OFFHAND;

            if (offhand.is(ModItems.TROPHY.get())){
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1, false, false));
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.JUMP, 20, 1, false, false));
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 1, false, false));
            }

        }
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add mod content to relevant creative tabs
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.GREENSTONE);
            event.accept(ModItems.RAW_GREENSTONE);
            event.accept(ModItems.RUBY);
            event.accept(ModItems.RAW_RUBY);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.POLISHED_GREENSTONE_BLOCK);
            event.accept(ModBlocks.RAW_GREENSTONE_BLOCK);
            event.accept(ModBlocks.SIX_SEVEN_BLOCK);
            event.accept(ModBlocks.WALLRUN_BLOCK);
            event.accept(ModBlocks.POLISHED_RUBY_BLOCK);
            event.accept(ModBlocks.RAW_RUBY_BLOCK);
            event.accept(ModBlocks.LEO_FULLER_BLOCK);
            event.accept(ModBlocks.OLIVER_REGAN_COE_BLOCK);
            event.accept(ModBlocks.HAYDEN_DAMAN_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.CLOUD_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ARROW_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.TROPHY);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.WIND_CHARGE_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SPEED_ESSENCE);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.TROPHY_SHARD);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
