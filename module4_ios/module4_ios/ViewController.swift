//
//  ViewController.swift
//  module4_ios
//
//  Created by Igor Vedeneev on 01/06/2018.
//  Copyright © 2018 AGIMA Education. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        navigationController?.navigationBar.prefersLargeTitles = true
    }
    
    @IBAction func action(_ sender: Any) {
        navigationController?.pushViewController(TableViewController(), animated: true)
    }
}

