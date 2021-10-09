package mekanism.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import org.lwjgl.opengl.GL11;

public class MekanismRenderType extends RenderLayer {

    private static final AlphaState CUBOID_ALPHA = new RenderState.AlphaState(0.1F);
    private static final RenderState.TransparencyState BLADE_TRANSPARENCY = new RenderState.TransparencyState("mek_blade_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(SrcFactor.ONE, DstFactor.ONE_MINUS_SRC_ALPHA);
    }, RenderSystem::disableBlend);
    private static final RenderState.TransparencyState PARTICLE_TRANSPARENCY = new RenderState.TransparencyState("mek_particle_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
    }, RenderSystem::disableBlend);

    public static final RenderLayer MEK_LIGHTNING = create("mek_lightning", VertexFormats.POSITION_COLOR, GL11.GL_QUADS, 256,
            false, true, RenderLayer.MultiPhaseParameters.builder()
                    .writeMaskState(COLOR_DEPTH_WRITE)
                    .setTransparencyState(LIGHTNING_TRANSPARENCY)
                    .setShadeModelState(SMOOTH_SHADE)
                    .createCompositeState(false)
    );

    //Ignored
    private MekanismRenderType(String name, VertexFormat format, int drawMode, int bufferSize, boolean useDelegate, boolean needsSorting, Runnable runnablePre, Runnable runnablePost) {
        super(name, format, drawMode, bufferSize, useDelegate, needsSorting, runnablePre, runnablePost);
    }

    public static RenderLayer mekStandard(Identifier resourceLocation) {
        RenderLayer.State state = RenderLayer.State.builder()
                .setTextureState(new RenderState.TextureState(resourceLocation, false, false))//Texture state
                .setShadeModelState(SMOOTH_SHADE)//shadeModel(GL11.GL_SMOOTH)
                .setAlphaState(NO_ALPHA)//disableAlphaTest
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)//enableBlend/blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA)
                .createCompositeState(true);
        return create("mek_standard", DefaultVertexFormats.NEW_ENTITY, GL11.GL_QUADS, 256, true, false, state);
    }

    public static RenderLayer bladeRender(Identifier resourceLocation) {
        RenderLayer.State state = RenderLayer.State.builder()
                .setTextureState(new RenderState.TextureState(resourceLocation, false, false))//Texture state
                .setShadeModelState(SMOOTH_SHADE)
                .setTransparencyState(BLADE_TRANSPARENCY)
                .createCompositeState(true);
        return create("mek_blade", DefaultVertexFormats.NEW_ENTITY, GL11.GL_QUADS, 256, true, false, state);
    }

    public static RenderLayer renderFlame(Identifier resourceLocation) {
        RenderLayer.State state = RenderLayer.State.builder()
                .setTextureState(new RenderState.TextureState(resourceLocation, false, false))//Texture state
                .setShadeModelState(SMOOTH_SHADE)//shadeModel(GL11.GL_SMOOTH)
                .setAlphaState(NO_ALPHA)//disableAlphaTest
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)//enableBlend/blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA)
                .setLightmapState(NO_LIGHTMAP)//disableLighting
                .createCompositeState(true);
        return create("mek_flame", DefaultVertexFormats.POSITION_COLOR_TEX, GL11.GL_QUADS, 256, true, false, state);
    }

    public static RenderLayer nutritionalParticle() {
        return create("mek_nutritional_particle", DefaultVertexFormats.POSITION_COLOR_TEX_LIGHTMAP, GL11.GL_QUADS, 256, false, false,
                RenderLayer.State.builder()
                        .setTextureState(new RenderState.TextureState(AtlasTexture.LOCATION_BLOCKS, false, false))
                        .setTransparencyState(PARTICLE_TRANSPARENCY)
                        .setAlphaState(DEFAULT_ALPHA)
                        .createCompositeState(false)
        );
    }

    public static RenderLayer getMekaSuit() {
        RenderLayer.State state = RenderLayer.State.builder()
                .setTextureState(BLOCK_SHEET)
                .setDiffuseLightingState(DIFFUSE_LIGHTING)
                .setShadeModelState(SMOOTH_SHADE)
                .setAlphaState(MIDWAY_ALPHA)
                .setLightmapState(LIGHTMAP)
                .createCompositeState(true);
        return create("mekasuit", DefaultVertexFormats.BLOCK, GL11.GL_QUADS, 131_072, true, true, state);
    }

    public static RenderLayer renderSPS(Identifier resourceLocation) {
        RenderLayer.State state = RenderLayer.State.builder()
                .setTextureState(new RenderState.TextureState(resourceLocation, false, false))//Texture state
                .setShadeModelState(SMOOTH_SHADE)//shadeModel(GL11.GL_SMOOTH)
                .setTransparencyState(LIGHTNING_TRANSPARENCY)//enableBlend/blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA)
                .setLightmapState(NO_LIGHTMAP)
                .setAlphaState(CUBOID_ALPHA)
                .createCompositeState(true);
        return create("mek_sps", DefaultVertexFormats.POSITION_COLOR_TEX, GL11.GL_QUADS, 256, true, false, state);
    }
}