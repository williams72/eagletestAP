package com.dilatoit.engine.pipes;

import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.enums.RealMobileTime;
import com.dilatoit.engine.exception.EngineException;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public interface RealMobilePipe {
    /**
     * get all realmobiles info
     * @return
     * @throws EngineException
     */
    public String realmobiles() throws EngineException;

    /**
     * get all realmobiles info by os type
     * @param mobileOsType
     * @return
     * @throws EngineException
     */
    public String realmobilesByOs(MobileOsEnum mobileOsType) throws EngineException;

    /**
     * rent a real mobile
     *
     * @param realMobileId the mobile`s unique identifier
     *                 forexample: mobile`s serial number
     * @param time use the mobile`s time
     * @return
     *         status : success | fail
     * @throws EngineException
     */
    public String rent(String realMobileId, RealMobileTime realMobileTime) throws EngineException;

    /**
     * get the real mobile info has used
     * @param realMobileId the mobile`s unique identifier
     *                 forexample: mobile`s serial number
     * @return
     * @throws EngineException
     */
    public String realmobileinfo(String realMobileId) throws EngineException;

    /**
     * renewal a mobile
     * @param realMobileId the mobile`s unique identifier
     *                 forexample: mobile`s serial number
     * @return
     * @throws EngineException
     */
    public String renewal(String realMobileId) throws EngineException;

    /**
     * stop a real mobile
     * @param realMobileId
     * @return
     * @throws EngineException
     */
    public String stop(String realMobileId) throws EngineException;

    /**
     * stop all a real mobile`s tiaoshi task
     * @param realMobileId
     * @return
     * @throws EngineException
     */
    public String stopAll(String realMobileId) throws EngineException;
}
