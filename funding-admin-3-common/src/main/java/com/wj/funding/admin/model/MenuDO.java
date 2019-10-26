package com.wj.funding.admin.model;

import java.util.ArrayList;
import java.util.List;

public class MenuDO {
    private Integer id;

    private Integer pid;

    private String name;

    private String url;

    private String icon;

    // 当前节点的子节点集合，设置默认值是为了避免组装节点时空指针异常
    private List<MenuDO> children = new ArrayList<>();

    // 控制节点展开还是折叠，设置为true是让整个树形菜单默认展开
    private Boolean open = true;

    public List<MenuDO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuDO> children) {
        this.children = children;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getOpen() {
        return open;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}