package bankapp.domain.ports;

import bankapp.domain.models.Binnacle;

public interface BinnaclePort {
    // if the binnacle exists
    public boolean existsById(long id);
    
    public Binnacle findById(long id);
    
    public void save(Binnacle binnacle);
}