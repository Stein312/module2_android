//
//  UserService.swift
//  module4_ios
//
//  Created by Igor Vedeneev on 01/06/2018.
//  Copyright © 2018 AGIMA Education. All rights reserved.
//

import Foundation


final class UserListPresenter {
    init(view: TableViewController) {
        self.view = view
    }
    
    var view: TableViewController
    
    func loadUsers() {
        DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) {
            let users = ["Tow Dwan", "Phil Helmuth", "Ole Schemion", "Timofey Kuznetsov", "Ivan Demidov", "Daniel Colman", "Liv Boeree"]
            self.view.reload(usersList: users)
        }
    }
    
    func runTestMethod() {
        #if targetEnvironment(simulator)
        exit(1)
        #else
        print("hellooooooo")
        #endif
    }
}
