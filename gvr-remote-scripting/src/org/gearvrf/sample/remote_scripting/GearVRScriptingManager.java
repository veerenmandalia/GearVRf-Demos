/* Copyright 2015 Samsung Electronics Co., LTD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gearvrf.sample.remote_scripting;

import android.app.Activity;
import android.os.Bundle;
import org.gearvrf.GVRActivity;
import org.gearvrf.GVRScript;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRScene;
import org.gearvrf.scene_objects.GVRTextViewSceneObject;
import android.view.Gravity;

public class GearVRScriptingManager extends GVRScript
{
    @Override
    public void onInit(GVRContext gvrContext) {
        gvrContext.startDebugServer();
        GVRScene scene = gvrContext.getNextMainScene();

        // get the ip address
        GearVRScripting activity = (GearVRScripting) gvrContext.getActivity();
        String ipAddress = activity.getIpAddress();
        String telnetString = "telnet " + ipAddress + " 1645";

        // create text object to tell the user where to connect
        GVRTextViewSceneObject textViewSceneObject = new GVRTextViewSceneObject(gvrContext, gvrContext.getActivity(), telnetString);
        textViewSceneObject.setGravity(Gravity.CENTER);
        textViewSceneObject.setTextSize(textViewSceneObject.getTextSize() * 1.2f);
        textViewSceneObject.getTransform().setPosition(0.0f, 0.0f, -3.0f);

        // make sure to set a name so we can reference it when we log in
        textViewSceneObject.setName("text");

        // add it to the scene
        scene.addSceneObject(textViewSceneObject);
    }

    @Override
    public void onStep() {
    }
}
