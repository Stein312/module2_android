//
//  TableViewController.swift
//  module4_ios
//
//  Created by Igor Vedeneev on 01/06/2018.
//  Copyright © 2018 AGIMA Education. All rights reserved.
//

import UIKit

private let cellIdentifier = "cell"

class TableViewController: UITableViewController {
    
    private lazy var presenter = UserListPresenter(view: self)
    private var users = [String]()
    private let loadingView = UIActivityIndicatorView.init(activityIndicatorStyle: .gray)

    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Poker players"
        setupLoadingFooter()
        loadingView.startAnimating()
        tableView.register(UITableViewCell.self, forCellReuseIdentifier: cellIdentifier)
        presenter.loadUsers()
    }
    
    func setupLoadingFooter() {
        loadingView.frame = CGRect(x: 0, y: 0, width: 20, height: 50)
        tableView.tableFooterView = loadingView
    }
    
    func reload(usersList: [String]) {
        users = usersList
        tableView.reloadData()
        loadingView.stopAnimating()
    }
    
    // MARK: - Table view data source
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return users.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier, for: indexPath)

        cell.textLabel?.text = users[indexPath.row]

        return cell
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        presenter.runTestMethod()
    }
}
