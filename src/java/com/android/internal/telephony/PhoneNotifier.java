/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.telephony;

import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneCapability;
import android.telephony.PhysicalChannelConfig;
import android.telephony.TelephonyManager;

import java.util.List;

/**
 * {@hide}
 */
public interface PhoneNotifier {

    public void notifyPhoneState(Phone sender);

    public void notifyServiceState(Phone sender);

    /** Notify registrants of the current CellLocation */
    void notifyCellLocation(Phone sender, CellLocation cl);

    public void notifySignalStrength(Phone sender);

    public void notifyMessageWaitingChanged(Phone sender);

    public void notifyCallForwardingChanged(Phone sender);

    /** TODO - reason should never be null */
    public void notifyDataConnection(Phone sender, String reason, String apnType,
            PhoneConstants.DataState state);

    public void notifyDataConnectionFailed(Phone sender, String reason, String apnType);

    public void notifyDataActivity(Phone sender);

    public void notifyOtaspChanged(Phone sender, int otaspMode);

    public void notifyCellInfo(Phone sender, List<CellInfo> cellInfo);

    /** Notify of change to PhysicalChannelConfiguration. */
    void notifyPhysicalChannelConfiguration(Phone sender, List<PhysicalChannelConfig> configs);

    public void notifyPreciseCallState(Phone sender);

    public void notifyDisconnectCause(int cause, int preciseCause);

    public void notifyPreciseDataConnectionFailed(Phone sender, String reason, String apnType,
            String apn, String failCause);

    /** send a notification that the SRVCC state has changed.*/
    void notifySrvccStateChanged(Phone sender, @TelephonyManager.SrvccState int state);

    public void notifyVoiceActivationStateChanged(Phone sender, int activationState);

    public void notifyDataActivationStateChanged(Phone sender, int activationState);

    public void notifyUserMobileDataStateChanged(Phone sender, boolean state);

    public void notifyOemHookRawEventForSubscriber(int subId, byte[] rawData);

    public void notifyPhoneCapabilityChanged(PhoneCapability capability);

    void notifyRadioPowerStateChanged(@TelephonyManager.RadioPowerState int state);
}
