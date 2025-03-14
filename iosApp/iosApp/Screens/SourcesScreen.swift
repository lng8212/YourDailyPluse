//
//  SourcesScreen.swift
//  iosApp
//
//  Created by Kiều Long on 14/3/25.
//  Copyright © 2025 orgName. All rights reserved.
//
import SwiftUI
import shared

extension SourcesScreen {
    
    @MainActor
    class SourceViewModelWrapper: ObservableObject {
        let sourceViewModel: SourceViewModel
        
        
        init() {
            sourceViewModel = SourcesInjector().sourceViewModel
            sourceState = sourceViewModel.sourceState.value
        }
        
        @Published var sourceState: SourceState
        
        func startObserving() {
            Task {
                for await sourceS in sourceViewModel.sourceState {
                    self.sourceState = sourceS
                }
            }
        }
    }
}

struct SourcesScreen: View {
    
    @ObservedObject private(set) var viewModel: SourceViewModelWrapper
    
    @Environment(\.dismiss)
    private var dismiss
    
    var body: some View {
        NavigationStack {
            VStack {
                if viewModel.sourceState.loading {
                    Loader()
                }
                
                if let error = viewModel.sourceState.error {
                    ErrorMessage(message: error)
                }
                
                if(!viewModel.sourceState.sources.isEmpty) {
                    ScrollView {
                        LazyVStack(spacing: 10) {
                            ForEach(viewModel.sourceState.sources, id: \.self) { source in
                                SourceItemView(source: source)
                            }
                        }
                    }
                }
                
            }.onAppear{
                self.viewModel.startObserving()
            }
            .navigationTitle("Source")
            .toolbar {
                ToolbarItem(placement: .primaryAction) {
                    Button {
                        dismiss()
                    } label: {
                        Text("Done")
                            .bold()
                    }
                }
            }
        }
    }
}

struct SourceItemView: View {
    var source: Source
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(source.name)
                .font(.title)
                .fontWeight(.bold)
            Text(source.description)
            Text(source.country).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
        }
        .padding(16)
    }
}
