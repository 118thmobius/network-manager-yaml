package org.mobiusone.networkmanager.entity.layer3;

import org.mobiusone.networkmanager.entity.annotation.Entity;

@Entity(layer = 3)
public interface NetworkAddr extends Cloneable{
    String toAddrBodyString();
}
