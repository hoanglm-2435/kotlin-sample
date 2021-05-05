source "https://rubygems.org"

gem "fastlane"
gem 'unf_ext', '~> 0.0.7.7'

plugins_path = File.join(File.dirname(__FILE__), 'fastlane', 'Pluginfile')
eval_gemfile(plugins_path) if File.exist?(plugins_path)
