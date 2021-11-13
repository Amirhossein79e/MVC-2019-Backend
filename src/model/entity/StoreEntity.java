package model.entity;

public class StoreEntity {
    private Long code;
    private String name;
    public StoreEntity setCode(Long code)
    {
        this.code= code;
        return this;
    }
    public StoreEntity setName(String name)
    {
        this.name = name;
        return this;
    }
    public Long getCode()
    {
        return code;
    }
    public String getName()
    {
        return name;
    }
}
