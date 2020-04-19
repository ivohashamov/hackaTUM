"""Generates submodule to allow deprecation of submodules and keeping git
blame."""
from pathlib import Path
from contextlib import suppress

# TODO: Remove the whole file in 0.24

# This is a set of 4-tuples consisting of
# (new_module_name, deprecated_path, correct_import_path, importee)
# importee is used by test_import_deprecations to check for DeprecationWarnings
_DEPRECATED_MODULES = [
    ('_mocking', 'sklearn_lib.utils.mocking', 'sklearn_lib.utils',
     'MockDataFrame'),

    ('_bagging', 'sklearn_lib.ensemble.bagging', 'sklearn_lib.ensemble',
     'BaggingClassifier'),
    ('_base', 'sklearn_lib.ensemble.base', 'sklearn_lib.ensemble',
     'BaseEnsemble'),
    ('_forest', 'sklearn_lib.ensemble.forest', 'sklearn_lib.ensemble',
     'RandomForestClassifier'),
    ('_gb', 'sklearn_lib.ensemble.gradient_boosting', 'sklearn_lib.ensemble',
     'GradientBoostingClassifier'),
    ('_iforest', 'sklearn_lib.ensemble.iforest', 'sklearn_lib.ensemble',
     'IsolationForest'),
    ('_voting', 'sklearn_lib.ensemble.voting', 'sklearn_lib.ensemble',
     'VotingClassifier'),
    ('_weight_boosting', 'sklearn_lib.ensemble.weight_boosting',
     'sklearn_lib.ensemble', 'AdaBoostClassifier'),
    ('_classes', 'sklearn_lib.tree.tree', 'sklearn_lib.tree',
     'DecisionTreeClassifier'),
    ('_export', 'sklearn_lib.tree.export', 'sklearn_lib.tree', 'export_graphviz'),

    ('_rbm', 'sklearn_lib.neural_network.rbm', 'sklearn_lib.neural_network',
     'BernoulliRBM'),
    ('_multilayer_perceptron', 'sklearn_lib.neural_network.multilayer_perceptron',
     'sklearn_lib.neural_network', 'MLPClassifier'),

    ('_weight_vector', 'sklearn_lib.utils.weight_vector', 'sklearn_lib.utils',
     'WeightVector'),
    ('_seq_dataset', 'sklearn_lib.utils.seq_dataset', 'sklearn_lib.utils',
     'ArrayDataset32'),
    ('_fast_dict', 'sklearn_lib.utils.fast_dict', 'sklearn_lib.utils', 'IntFloatDict'),

    ('_affinity_propagation', 'sklearn_lib.cluster.affinity_propagation_',
     'sklearn_lib.cluster', 'AffinityPropagation'),
    ('_bicluster', 'sklearn_lib.cluster.bicluster', 'sklearn_lib.cluster',
     'SpectralBiclustering'),
    ('_birch', 'sklearn_lib.cluster.birch', 'sklearn_lib.cluster', 'Birch'),
    ('_dbscan', 'sklearn_lib.cluster.dbscan_', 'sklearn_lib.cluster', 'DBSCAN'),
    ('_agglomerative', 'sklearn_lib.cluster.hierarchical', 'sklearn_lib.cluster',
     'FeatureAgglomeration'),
    ('_kmeans', 'sklearn_lib.cluster.k_means_', 'sklearn_lib.cluster', 'KMeans'),
    ('_mean_shift', 'sklearn_lib.cluster.mean_shift_', 'sklearn_lib.cluster',
     'MeanShift'),
    ('_optics', 'sklearn_lib.cluster.optics_', 'sklearn_lib.cluster', 'OPTICS'),
    ('_spectral', 'sklearn_lib.cluster.spectral', 'sklearn_lib.cluster',
     'SpectralClustering'),

    ('_base', 'sklearn_lib.mixture.base', 'sklearn_lib.mixture', 'BaseMixture'),
    ('_gaussian_mixture', 'sklearn_lib.mixture.gaussian_mixture',
     'sklearn_lib.mixture', 'GaussianMixture'),
    ('_bayesian_mixture', 'sklearn_lib.mixture.bayesian_mixture',
     'sklearn_lib.mixture', 'BayesianGaussianMixture'),

    ('_empirical_covariance', 'sklearn_lib.covariance.empirical_covariance_',
     'sklearn_lib.covariance', 'EmpiricalCovariance'),
    ('_shrunk_covariance', 'sklearn_lib.covariance.shrunk_covariance_',
     'sklearn_lib.covariance', 'ShrunkCovariance'),
    ('_robust_covariance', 'sklearn_lib.covariance.robust_covariance',
     'sklearn_lib.covariance', 'MinCovDet'),
    ('_graph_lasso', 'sklearn_lib.covariance.graph_lasso_',
     'sklearn_lib.covariance', 'GraphicalLasso'),
    ('_elliptic_envelope', 'sklearn_lib.covariance.elliptic_envelope',
     'sklearn_lib.covariance', 'EllipticEnvelope'),

    ('_cca', 'sklearn_lib.cross_decomposition.cca_',
     'sklearn_lib.cross_decomposition', 'CCA'),
    ('_pls', 'sklearn_lib.cross_decomposition.pls_',
     'sklearn_lib.cross_decomposition', 'PLSSVD'),

    ('_base', 'sklearn_lib.svm.base', 'sklearn_lib.svm', 'BaseLibSVM'),
    ('_bounds', 'sklearn_lib.svm.bounds', 'sklearn_lib.svm', 'l1_min_c'),
    ('_classes', 'sklearn_lib.svm.classes', 'sklearn_lib.svm', 'SVR'),
    ('_libsvm', 'sklearn_lib.svm.libsvm', 'sklearn_lib.svm', 'fit'),
    ('_libsvm_sparse', 'sklearn_lib.svm.libsvm_sparse', 'sklearn_lib.svm',
     'set_verbosity_wrap'),
    ('_liblinear', 'sklearn_lib.svm.liblinear', 'sklearn_lib.svm', 'train_wrap'),

    ('_base', 'sklearn_lib.decomposition.base', 'sklearn_lib.decomposition',
     'BaseEstimator'),
    ('_dict_learning', 'sklearn_lib.decomposition.dict_learning',
     'sklearn_lib.decomposition', 'MiniBatchDictionaryLearning'),
    ('_cdnmf_fast', 'sklearn_lib.decomposition.cdnmf_fast',
     'sklearn_lib.decomposition', '__dict__'),
    ('_factor_analysis', 'sklearn_lib.decomposition.factor_analysis',
     'sklearn_lib.decomposition', 'FactorAnalysis'),
    ('_fastica', 'sklearn_lib.decomposition.fastica_', 'sklearn_lib.decomposition',
     'FastICA'),
    ('_incremental_pca', 'sklearn_lib.decomposition.incremental_pca',
     'sklearn_lib.decomposition', 'IncrementalPCA'),
    ('_kernel_pca', 'sklearn_lib.decomposition.kernel_pca',
     'sklearn_lib.decomposition', 'KernelPCA'),
    ('_nmf', 'sklearn_lib.decomposition.nmf', 'sklearn_lib.decomposition', 'NMF'),
    ('_lda', 'sklearn_lib.decomposition.online_lda',
     'sklearn_lib.decomposition', 'LatentDirichletAllocation'),
    ('_online_lda_fast', 'sklearn_lib.decomposition.online_lda_fast',
     'sklearn_lib.decomposition', 'mean_change'),
    ('_pca', 'sklearn_lib.decomposition.pca', 'sklearn_lib.decomposition', 'PCA'),
    ('_sparse_pca', 'sklearn_lib.decomposition.sparse_pca',
     'sklearn_lib.decomposition', 'SparsePCA'),
    ('_truncated_svd', 'sklearn_lib.decomposition.truncated_svd',
     'sklearn_lib.decomposition', 'TruncatedSVD'),

    ('_gpr', 'sklearn_lib.gaussian_process.gpr', 'sklearn_lib.gaussian_process',
     'GaussianProcessRegressor'),
    ('_gpc', 'sklearn_lib.gaussian_process.gpc', 'sklearn_lib.gaussian_process',
     'GaussianProcessClassifier'),

    ('_base', 'sklearn_lib.datasets.base', 'sklearn_lib.datasets', 'get_data_home'),
    ('_california_housing', 'sklearn_lib.datasets.california_housing',
     'sklearn_lib.datasets', 'fetch_california_housing'),
    ('_covtype', 'sklearn_lib.datasets.covtype', 'sklearn_lib.datasets',
     'fetch_covtype'),
    ('_kddcup99', 'sklearn_lib.datasets.kddcup99', 'sklearn_lib.datasets',
     'fetch_kddcup99'),
    ('_lfw', 'sklearn_lib.datasets.lfw', 'sklearn_lib.datasets',
     'fetch_lfw_people'),
    ('_olivetti_faces', 'sklearn_lib.datasets.olivetti_faces', 'sklearn_lib.datasets',
     'fetch_olivetti_faces'),
    ('_openml', 'sklearn_lib.datasets.openml', 'sklearn_lib.datasets', 'fetch_openml'),
    ('_rcv1', 'sklearn_lib.datasets.rcv1', 'sklearn_lib.datasets', 'fetch_rcv1'),
    ('_samples_generator', 'sklearn_lib.datasets.samples_generator',
     'sklearn_lib.datasets', 'make_classification'),
    ('_species_distributions', 'sklearn_lib.datasets.species_distributions',
     'sklearn_lib.datasets', 'fetch_species_distributions'),
    ('_svmlight_format_io', 'sklearn_lib.datasets.svmlight_format',
     'sklearn_lib.datasets', 'load_svmlight_file'),
    ('_twenty_newsgroups', 'sklearn_lib.datasets.twenty_newsgroups',
     'sklearn_lib.datasets', 'strip_newsgroup_header'),

    ('_dict_vectorizer', 'sklearn_lib.feature_extraction.dict_vectorizer',
     'sklearn_lib.feature_extraction', 'DictVectorizer'),
    ('_hash', 'sklearn_lib.feature_extraction.hashing',
     'sklearn_lib.feature_extraction', 'FeatureHasher'),
    ('_stop_words', 'sklearn_lib.feature_extraction.stop_words',
     'sklearn_lib.feature_extraction.text', 'ENGLISH_STOP_WORDS'),

    ('_base', 'sklearn_lib.linear_model.base', 'sklearn_lib.linear_model',
     'LinearRegression'),
    ('_cd_fast', 'sklearn_lib.linear_model.cd_fast', 'sklearn_lib.linear_model',
     'sparse_enet_coordinate_descent'),
    ('_bayes', 'sklearn_lib.linear_model.bayes', 'sklearn_lib.linear_model',
     'BayesianRidge'),
    ('_coordinate_descent', 'sklearn_lib.linear_model.coordinate_descent',
     'sklearn_lib.linear_model', 'Lasso'),
    ('_huber', 'sklearn_lib.linear_model.huber', 'sklearn_lib.linear_model',
     'HuberRegressor'),
    ('_least_angle', 'sklearn_lib.linear_model.least_angle',
     'sklearn_lib.linear_model', 'LassoLarsCV'),
    ('_logistic', 'sklearn_lib.linear_model.logistic', 'sklearn_lib.linear_model',
     'LogisticRegression'),
    ('_omp', 'sklearn_lib.linear_model.omp', 'sklearn_lib.linear_model',
     'OrthogonalMatchingPursuit'),
    ('_passive_aggressive', 'sklearn_lib.linear_model.passive_aggressive',
     'sklearn_lib.linear_model', 'PassiveAggressiveClassifier'),
    ('_perceptron', 'sklearn_lib.linear_model.perceptron', 'sklearn_lib.linear_model',
     'Perceptron'),
    ('_ransac', 'sklearn_lib.linear_model.ransac', 'sklearn_lib.linear_model',
     'RANSACRegressor'),
    ('_ridge', 'sklearn_lib.linear_model.ridge', 'sklearn_lib.linear_model',
     'Ridge'),
    ('_sag', 'sklearn_lib.linear_model.sag', 'sklearn_lib.linear_model',
     'get_auto_step_size'),
    ('_sag_fast', 'sklearn_lib.linear_model.sag_fast', 'sklearn_lib.linear_model',
     'MultinomialLogLoss64'),
    ('_sgd_fast', 'sklearn_lib.linear_model.sgd_fast', 'sklearn_lib.linear_model',
     'Hinge'),
    ('_stochastic_gradient', 'sklearn_lib.linear_model.stochastic_gradient',
     'sklearn_lib.linear_model', 'SGDClassifier'),
    ('_theil_sen', 'sklearn_lib.linear_model.theil_sen', 'sklearn_lib.linear_model',
     'TheilSenRegressor'),

    ('_bicluster', 'sklearn_lib.metrics.cluster.bicluster',
     'sklearn_lib.metrics.cluster', 'consensus_score'),
    ('_supervised', 'sklearn_lib.metrics.cluster.supervised',
     'sklearn_lib.metrics.cluster', 'entropy'),
    ('_unsupervised', 'sklearn_lib.metrics.cluster.unsupervised',
     'sklearn_lib.metrics.cluster', 'silhouette_score'),
    ('_expected_mutual_info_fast',
     'sklearn_lib.metrics.cluster.expected_mutual_info_fast',
     'sklearn_lib.metrics.cluster', 'expected_mutual_information'),

    ('_base', 'sklearn_lib.metrics.base', 'sklearn_lib.metrics', 'combinations'),
    ('_classification', 'sklearn_lib.metrics.classification', 'sklearn_lib.metrics',
     'accuracy_score'),
    ('_regression', 'sklearn_lib.metrics.regression', 'sklearn_lib.metrics',
     'max_error'),
    ('_ranking', 'sklearn_lib.metrics.ranking', 'sklearn_lib.metrics', 'roc_curve'),
    ('_pairwise_fast', 'sklearn_lib.metrics.pairwise_fast', 'sklearn_lib.metrics',
     'np'),
    ('_scorer', 'sklearn_lib.metrics.scorer', 'sklearn_lib.metrics', 'get_scorer'),

    ('_partial_dependence', 'sklearn_lib.inspection.partial_dependence',
     'sklearn_lib.inspection', 'partial_dependence'),

    ('_ball_tree', 'sklearn_lib.neighbors.ball_tree', 'sklearn_lib.neighbors',
     'BallTree'),
    ('_base', 'sklearn_lib.neighbors.base', 'sklearn_lib.neighbors',
     'VALID_METRICS'),
    ('_classification', 'sklearn_lib.neighbors.classification',
     'sklearn_lib.neighbors', 'KNeighborsClassifier'),
    ('_dist_metrics', 'sklearn_lib.neighbors.dist_metrics', 'sklearn_lib.neighbors',
     'DistanceMetric'),
    ('_graph', 'sklearn_lib.neighbors.graph', 'sklearn_lib.neighbors',
     'KNeighborsTransformer'),
    ('_kd_tree', 'sklearn_lib.neighbors.kd_tree', 'sklearn_lib.neighbors',
     'KDTree'),
    ('_kde', 'sklearn_lib.neighbors.kde', 'sklearn_lib.neighbors',
     'KernelDensity'),
    ('_lof', 'sklearn_lib.neighbors.lof', 'sklearn_lib.neighbors',
     'LocalOutlierFactor'),
    ('_nca', 'sklearn_lib.neighbors.nca', 'sklearn_lib.neighbors',
     'NeighborhoodComponentsAnalysis'),
    ('_nearest_centroid', 'sklearn_lib.neighbors.nearest_centroid',
     'sklearn_lib.neighbors', 'NearestCentroid'),
    ('_quad_tree', 'sklearn_lib.neighbors.quad_tree', 'sklearn_lib.neighbors',
     'CELL_DTYPE'),
    ('_regression', 'sklearn_lib.neighbors.regression', 'sklearn_lib.neighbors',
     'KNeighborsRegressor'),
    ('_typedefs', 'sklearn_lib.neighbors.typedefs', 'sklearn_lib.neighbors',
     'DTYPE'),
    ('_unsupervised', 'sklearn_lib.neighbors.unsupervised', 'sklearn_lib.neighbors',
     'NearestNeighbors'),

    ('_isomap', 'sklearn_lib.manifold.isomap', 'sklearn_lib.manifold', 'Isomap'),
    ('_locally_linear', 'sklearn_lib.manifold.locally_linear', 'sklearn_lib.manifold',
     'LocallyLinearEmbedding'),
    ('_mds', 'sklearn_lib.manifold.mds', 'sklearn_lib.manifold', 'MDS'),
    ('_spectral_embedding', 'sklearn_lib.manifold.spectral_embedding_',
     'sklearn_lib.manifold', 'SpectralEmbedding'),
    ('_t_sne', 'sklearn_lib.manifold.t_sne', 'sklearn_lib.manifold', 'TSNE'),

    ('_label_propagation', 'sklearn_lib.semi_supervised.label_propagation',
     'sklearn_lib.semi_supervised', 'LabelPropagation'),

    ('_data', 'sklearn_lib.preprocessing.data', 'sklearn_lib.preprocessing',
     'Binarizer'),
    ('_label', 'sklearn_lib.preprocessing.label', 'sklearn_lib.preprocessing',
     'LabelEncoder'),

    ('_base', 'sklearn_lib.feature_selection.base', 'sklearn_lib.feature_selection',
     'SelectorMixin'),
    ('_from_model', 'sklearn_lib.feature_selection.from_model',
     'sklearn_lib.feature_selection', 'SelectFromModel'),
    ('_mutual_info', 'sklearn_lib.feature_selection.mutual_info',
     'sklearn_lib.feature_selection', 'mutual_info_regression'),
    ('_rfe', 'sklearn_lib.feature_selection.rfe',
     'sklearn_lib.feature_selection.rfe', 'RFE'),
    ('_univariate_selection',
     'sklearn_lib.feature_selection.univariate_selection',
     'sklearn_lib.feature_selection', 'chi2'),
    ('_variance_threshold',
     'sklearn_lib.feature_selection.variance_threshold',
     'sklearn_lib.feature_selection', 'VarianceThreshold'),

    ('_testing', 'sklearn_lib.utils.testing', 'sklearn_lib.utils',
     'all_estimators'),
]


_FILE_CONTENT_TEMPLATE = """
# THIS FILE WAS AUTOMATICALLY GENERATED BY deprecated_modules.py
import sys
from . import {new_module_name}
from {relative_dots}externals._pep562 import Pep562
from {relative_dots}utils.deprecation import _raise_dep_warning_if_not_pytest

deprecated_path = '{deprecated_path}'
correct_import_path = '{correct_import_path}'

_raise_dep_warning_if_not_pytest(deprecated_path, correct_import_path)

def __getattr__(name):
    return getattr({new_module_name}, name)

if not sys.version_info >= (3, 7):
    Pep562(__name__)
"""


def _get_deprecated_path(deprecated_path):
    deprecated_parts = deprecated_path.split(".")
    deprecated_parts[-1] = deprecated_parts[-1] + ".py"
    return Path(*deprecated_parts)


def _create_deprecated_modules_files():
    """Add submodules that will be deprecated. A file is created based
    on the deprecated submodule's name. When this submodule is imported a
    deprecation warning will be raised.
    """
    for (new_module_name, deprecated_path,
         correct_import_path, _) in _DEPRECATED_MODULES:
        relative_dots = deprecated_path.count(".") * "."
        deprecated_content = _FILE_CONTENT_TEMPLATE.format(
            new_module_name=new_module_name,
            relative_dots=relative_dots,
            deprecated_path=deprecated_path,
            correct_import_path=correct_import_path)

        with _get_deprecated_path(deprecated_path).open('w') as f:
            f.write(deprecated_content)


def _clean_deprecated_modules_files():
    """Removes submodules created by _create_deprecated_modules_files."""
    for _, deprecated_path, _, _ in _DEPRECATED_MODULES:
        with suppress(FileNotFoundError):
            _get_deprecated_path(deprecated_path).unlink()


if __name__ == "__main__":
    _clean_deprecated_modules_files()
