// package com.scm.entities;

// import java.util.ArrayList;
// import java.util.List;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.ElementCollection;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity(name = "user")
// @Table(name = "users")
// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
// @Builder
// public class User {

//     @Id
//     @Column(name = "user_id", length = 36, nullable = false)
//     private String userId;

//     @Column(name = "user_name", length = 255, nullable = false)
//     private String name;

//     @Column(name = "email", unique = true, length = 255, nullable = false)
//     private String email;

//     @Column(name = "password", length = 255, nullable = false)
//     private String password;

//     @Column(name = "about", length = 1000)
//     private String about;

//     @Column(name = "profile_pic", length = 10000)
//     private String profilePic;

//     @Column(name = "phone_number", length = 20)
//     private String phoneNumber;

//     // Information
//     @Builder.Default
//     @Column(name = "enabled", nullable = false)
//     private boolean enabled = false;

//     @Builder.Default
//     @Column(name = "email_verified", nullable = false)
//     private boolean emailVerified = false;

//     @Builder.Default
//     @Column(name = "phone_verified", nullable = false)
//     private boolean phoneVerified = false;

//     // Self, Google, Facebook, Twitter, LinkedIn, GitHub
//     @Enumerated(EnumType.STRING)
//     @Builder.Default
//     @Column(name = "provider", length = 20, nullable = false)
//     private Providers provider = Providers.SELF;

//     @Column(name = "provider_user_id", length = 255)
//     private String providerUserId;

//     @ElementCollection
//     @Column(name = "contacts")
//     @OneToMany(mappedBy = 'user' cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//     private List<Contact> contacts = new ArrayList<>();
// }

package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(name = "user_name", length = 255, nullable = false)
    private String name;

    @Column(name = "email", unique = true, length = 255, nullable = false)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "about", length = 1000)
    private String about;

    @Column(name = "profile_pic", length = 10000)
    private String profilePic;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    // Information
    @Builder.Default
    @Column(name = "enabled", nullable = false)
    private boolean enabled = false;

    @Builder.Default
    @Column(name = "email_verified", nullable = false)
    private boolean emailVerified = false;

    @Builder.Default
    @Column(name = "phone_verified", nullable = false)
    private boolean phoneVerified = false;

    // Self, Google, Facebook, Twitter, LinkedIn, GitHub
    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(name = "provider", length = 20, nullable = false)
    private Providers provider = Providers.SELF;

    @Column(name = "provider_user_id", length = 255)
    private String providerUserId;
    
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

}
