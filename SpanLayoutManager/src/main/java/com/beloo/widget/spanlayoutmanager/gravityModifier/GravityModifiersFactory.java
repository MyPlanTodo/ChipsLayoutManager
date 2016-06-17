package com.beloo.widget.spanlayoutmanager.gravityModifier;

import android.view.Gravity;

import com.beloo.widget.spanlayoutmanager.SpanLayoutChildGravity;

import java.util.HashMap;
import java.util.Map;

public class GravityModifiersFactory {

    public Map<Integer, IGravityModifier> gravityModifierMap;

    public GravityModifiersFactory() {
        gravityModifierMap = new HashMap<>();

        CenterGravityModifier centerGravityModifier = new CenterGravityModifier();
        TopGravityModifier topGravityModifier = new TopGravityModifier();
        BottomGravityModifier bottomGravityModifier = new BottomGravityModifier();

        gravityModifierMap.put(Gravity.TOP, topGravityModifier);
        gravityModifierMap.put(Gravity.BOTTOM, bottomGravityModifier);
        gravityModifierMap.put(Gravity.CENTER, centerGravityModifier);
        gravityModifierMap.put(Gravity.CENTER_VERTICAL, centerGravityModifier);
    }

    public IGravityModifier getGravityModifier(@SpanLayoutChildGravity int gravity) {
        IGravityModifier gravityModifier = gravityModifierMap.get(gravity);
        if (gravityModifier == null) {
            gravityModifier = gravityModifierMap.get(Gravity.CENTER_VERTICAL);
        }
        return gravityModifier;
    }

}