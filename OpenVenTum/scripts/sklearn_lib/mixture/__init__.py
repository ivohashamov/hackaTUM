"""
The :mod:`sklearn_lib.mixture` module implements mixture modeling algorithms.
"""

from ._gaussian_mixture import GaussianMixture
from ._bayesian_mixture import BayesianGaussianMixture


__all__ = ['GaussianMixture',
           'BayesianGaussianMixture']
