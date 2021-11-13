package controller;

import model.entity.StoreEntity;
import model.service.StoreService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/store")
public class StoreController {
    @Path("/insert")
    @Produces("text/plain")
    @GET
    public String insert(@QueryParam("code")String code,@QueryParam("name")String name) throws Exception
    {
        StoreEntity storeEntity = new StoreEntity().setCode(Long.parseLong(code)).setName(name);
        StoreService.getInstance().insert(storeEntity);
        return StoreService.getInstance().select();
    }

    @Path("/select")
    @Produces("text/plain")
    @GET
    public String select()throws Exception
    {
        return StoreService.getInstance().select();
    }

    @Path("/update")
    @Produces("text/plain")
    @GET
    public String update(@QueryParam("name")String name,@QueryParam("code")String code)throws Exception
    {
        StoreEntity storeEntity = new StoreEntity().setName(name).setCode(Long.parseLong(code));
        StoreService.getInstance().update(storeEntity);
        return StoreService.getInstance().select();
    }

    @Path("/delete")
    @Produces("text/plain")
    @GET
    public String delete(@QueryParam("code")String code)throws Exception
    {
        StoreEntity storeEntity = new StoreEntity().setCode(Long.parseLong(code));
        StoreService.getInstance().delete(storeEntity);
        return StoreService.getInstance().select();
    }

}
