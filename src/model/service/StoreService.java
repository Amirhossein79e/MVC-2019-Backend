package model.service;

import model.entity.StoreEntity;
import model.repository.StoreRepository;

public class StoreService {
    private StoreService(){}
    private static StoreService storeService = new StoreService();
    public static StoreService getInstance()
    {
        return storeService;
    }

    public void insert(StoreEntity storeEntity)throws Exception
    {
        try (StoreRepository storeRepository = new StoreRepository())
        {
        storeRepository.insert(storeEntity);
        }
    }

    public String select() throws Exception {
        try (StoreRepository storeRepository = new StoreRepository())
        {
        return storeRepository.select();
        }
    }

    public void update(StoreEntity storeEntity)throws Exception
    {
        try (StoreRepository storeRepository = new StoreRepository())
        {
            storeRepository.update(storeEntity);
        }
    }

    public void delete(StoreEntity storeEntity)throws Exception
    {
        try (StoreRepository storeRepository = new StoreRepository())
        {
        storeRepository.delete(storeEntity);
        }
    }
}
