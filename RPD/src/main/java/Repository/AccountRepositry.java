package Repository;

import Models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepositry extends CrudRepository<Account,Long> {

}
