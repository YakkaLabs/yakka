package com.yakka.flex.ai.core.model.video;

public interface VideoOptions {

    String getModel();

    Integer getWidth();

    Integer getHeight();

    Integer getDuration();

    String getImageSize();

    String getNegativePrompt();

    Integer getSeed();

    String getImage();
}
