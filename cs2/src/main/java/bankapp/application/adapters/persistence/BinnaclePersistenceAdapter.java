package bankapp.application.adapters.persistence;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bankapp.domain.ports.BinnaclePort;
import bankapp.domain.models.Binnacle;
import bankapp.domain.models.User;
import bankapp.application.adapters.persistence.sql.repositories.BinnacleRepository;
import bankapp.application.adapters.persistence.sql.entities.BinnacleEntity;

@Service
public class BinnaclePersistenceAdapter implements BinnaclePort {

    @Autowired
    private BinnacleRepository binnacleRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean existsById(long id) {
        return binnacleRepository.existsById(id);
    }

    @Override
    public Binnacle findById(long id) {
        BinnacleEntity entity = binnacleRepository.findById(id);
        return mapToDomain(entity);
    }

    @Override
    public void save(Binnacle binnacle) {
        BinnacleEntity entity = mapToEntity(binnacle);
        entity = binnacleRepository.save(entity);
        binnacle.setBinnacleId(entity.getBinnacleId());
    }

    private BinnacleEntity mapToEntity(Binnacle binnacle) {
        if (binnacle == null) {
            return null;
        }

        BinnacleEntity entity = new BinnacleEntity();
        entity.setBinnacleId(binnacle.getBinnacleId());
        entity.setOperationType(binnacle.getOperationType());
        entity.setOperationDate(binnacle.getOperationDate());
        entity.setUserId(binnacle.getUserId() != null ? binnacle.getUserId().getId() : null);
        entity.setProductId(binnacle.getProductId() != null ? binnacle.getProductId().getProductId() : null);
        entity.setDetailsJson(writeDetails(binnacle.getDetails()));
        return entity;
    }

    private Binnacle mapToDomain(BinnacleEntity entity) {
        if (entity == null) {
            return null;
        }

        Binnacle binnacle = new Binnacle();
        binnacle.setBinnacleId(entity.getBinnacleId());
        binnacle.setOperationType(entity.getOperationType());
        binnacle.setOperationDate(entity.getOperationDate());

        if (entity.getUserId() != null) {
            User user = new User();
            user.setId(entity.getUserId());
            binnacle.setUserId(user);
        }

        binnacle.setProductId(null);
        binnacle.setDetails(readDetails(entity.getDetailsJson()));
        return binnacle;
    }

    private String writeDetails(Object details) {
        if (details == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(details);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to serialize binnacle details", e);
        }
    }

    @SuppressWarnings("unchecked")
    private java.util.Map<String, Object> readDetails(String detailsJson) {
        if (detailsJson == null || detailsJson.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.readValue(detailsJson, java.util.Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to deserialize binnacle details", e);
        }
    }
}
