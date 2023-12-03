package org.mobiusone.networkmanager.core.entity.layer3;

import org.mobiusone.networkmanager.core.entity.annotation.Entity;

@Entity(layer = 3)
public interface NetworkAddr extends Cloneable{
    String toAddrBodyString();
}
