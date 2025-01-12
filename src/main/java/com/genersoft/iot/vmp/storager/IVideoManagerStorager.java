package com.genersoft.iot.vmp.storager;

import com.genersoft.iot.vmp.gb28181.bean.Device;
import com.genersoft.iot.vmp.gb28181.bean.DeviceChannel;
import com.genersoft.iot.vmp.gb28181.bean.MobilePosition;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description:视频设备数据存储接口
 * @author: swwheihei
 * @date: 2020年5月6日 下午2:14:31
 */
public interface IVideoManagerStorager {

    /**
     * 根据设备ID判断设备是否存在
     *
     * @param deviceId 设备ID
     * @return true:存在  false：不存在
     */
    public boolean exists(String deviceId);

    /**
     * 视频设备创建
     *
     * @param device 设备对象
     * @return true：创建成功  false：创建失败
     */
    public boolean create(Device device);

    /**
     * 视频设备更新
     *
     * @param device 设备对象
     * @return true：创建成功  false：创建失败
     */
    public boolean updateDevice(Device device);

    /**
     * 添加设备通道
     *
     * @param deviceId 设备id
     * @param channel  通道
     */
    public void updateChannel(String deviceId, DeviceChannel channel);

    /**
     * 开始播放
     *
     * @param deviceId  设备id
     * @param channelId 通道ID
     * @param streamId  流地址
     */
    public void startPlay(String deviceId, String channelId, String streamId);

    /**
     * 停止播放
     *
     * @param deviceId  设备id
     * @param channelId 通道ID
     */
    public void stopPlay(String deviceId, String channelId);

    /**
     * 获取设备
     *
     * @param deviceId 设备ID
     * @return DShadow 设备对象
     */
    public Device queryVideoDevice(String deviceId);

    /**
     * 获取某个设备的通道列表
     *
     * @param deviceId 设备ID
     * @param page     分页 当前页
     * @param count    每页数量
     * @return
     */
    public PageInfo queryChannelsByDeviceId(String deviceId, String query, Boolean hasSubChannel, Boolean online, int page, int count);

    /**
     * 获取某个设备的通道列表
     *
     * @param deviceId 设备ID
     * @return
     */
    public List<DeviceChannel> queryChannelsByDeviceId(String deviceId);

    /**
     * 获取某个设备的通道
     *
     * @param deviceId  设备ID
     * @param channelId 通道ID
     */
    public DeviceChannel queryChannel(String deviceId, String channelId);

    /**
     * 获取多个设备
     *
     * @param page  当前页数
     * @param count 每页数量
     * @return List<Device> 设备对象数组
     */
    public PageInfo<Device> queryVideoDeviceList(int page, int count);

    /**
     * 获取多个设备
     *
     * @return List<Device> 设备对象数组
     */
    public List<Device> queryVideoDeviceList();

    /**
     * 删除设备
     *
     * @param deviceId 设备ID
     * @return true：删除成功  false：删除失败
     */
    public boolean delete(String deviceId);

    /**
     * 更新设备在线
     *
     * @param deviceId 设备ID
     * @return true：更新成功  false：更新失败
     */
    public boolean online(String deviceId);

    /**
     * 更新设备离线
     *
     * @param deviceId 设备ID
     * @return true：更新成功  false：更新失败
     */
    public boolean outline(String deviceId);


    /**
     * 查询子设备
     *
     * @param deviceId
     * @param channelId
     * @param page
     * @param count
     * @return
     */
    PageInfo querySubChannels(String deviceId, String channelId, String query, Boolean hasSubChannel, String online, int page, int count);


    /**
     * 清空通道
     *
     * @param deviceId
     */
    void cleanChannelsForDevice(String deviceId);

    /**
     * 添加Mobile Position设备移动位置
     *
     * @param MobilePosition
     * @return
     */
    public boolean insertMobilePosition(MobilePosition mobilePosition);

    /**
     * 查询移动位置轨迹
     *
     * @param deviceId
     * @param startTime
     * @param endTime
     */
    public List<MobilePosition> queryMobilePositions(String deviceId, String startTime, String endTime);

    /**
     * 查询最新移动位置
     *
     * @param deviceId
     */
    public MobilePosition queryLatestPosition(String deviceId);

    /**
     * 删除指定设备的所有移动位置
     *
     * @param deviceId
     */
    public int clearMobilePositionsByDeviceId(String deviceId);
}
