package com.xingxue.plugin.ip.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2017/9/21.
 */
public class IpInfo {

    private String country; //国家
    @JSONField(name = "country_id")
    private String countryId; //"CN"
    private String area; //地区名称（华南、华北...）
    @JSONField(name = "area_id")
    private String areaId; //地区编号
    private String region; //省名称
    @JSONField(name = "region_id")
    private String regionId; //省编号
    private String city; //市名称
    @JSONField(name = "city_id")
    private String cityId; //市编号
    private String county; //县名称
    @JSONField(name = "county_id") private String countyId; //县编号
    private String isp; //ISP服务商名称（电信/联通/铁通/移动...）
    @JSONField(name = "isp_id") private String ispId; //ISP服务商编号
    private String ip; //查询的IP地址


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getIspId() {
        return ispId;
    }

    public void setIspId(String ispId) {
        this.ispId = ispId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "IpInfo{" +
                "country='" + country + '\'' +
                ", countryId='" + countryId + '\'' +
                ", area='" + area + '\'' +
                ", areaId='" + areaId + '\'' +
                ", region='" + region + '\'' +
                ", regionId='" + regionId + '\'' +
                ", city='" + city + '\'' +
                ", cityId='" + cityId + '\'' +
                ", county='" + county + '\'' +
                ", countyId='" + countyId + '\'' +
                ", isp='" + isp + '\'' +
                ", ispId='" + ispId + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
