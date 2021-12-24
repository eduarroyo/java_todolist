// package com.eduarroyo.todolist.service;

// import java.util.Optional;

// import com.eduarroyo.todolist.entity.User;
// import com.eduarroyo.todolist.repository.UserRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Example;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// @Service
// public class UserServiceImpl implements UserService {

//     @Autowired
//     private UserRepository rep;

//     @Override
//     @Transactional(readOnly=true)
//     public Iterable<User> findAll() {
//         return rep.findAll();
//     }

//     @Override
//     @Transactional(readOnly=true)
//     public Page<User> findAll(Pageable pageable) {
//         return rep.findAll(pageable);
//     }

//     @Override
//     @Transactional(readOnly=true)
//     public Optional<User> findById(Long userId) {
//         return rep.findById(userId);
//     }

//     @Override
//     @Transactional
//     public User save(User user) {
//         return rep.save(user);
//     }
    
//     @Override
//     @Transactional
//     public void deleteById(Long userId) {
//         rep.deleteById(userId);
//     }

//     @Override
//     public UserDetails loadUserByUsername(String usermaneOrEmail) throws UsernameNotFoundException {
//         User uExample = new User(usermaneOrEmail);
//         Example<User> example = Example.of(uExample);
//         Optional<User> found = rep.findOne(example);

//         if(found.isPresent()) {
//             return found.get();
//         } else {
//             throw new UsernameNotFoundException("El usuario " + usermaneOrEmail + " no existe.");
//         }
//     }
// }