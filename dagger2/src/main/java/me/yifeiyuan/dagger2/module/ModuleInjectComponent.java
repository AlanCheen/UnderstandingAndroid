/*
 * Copyright (C) 2016, 程序亦非猿
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.yifeiyuan.dagger2.module;

import dagger.Component;

/**
 * Created by 程序亦非猿 on 16/10/17.
 *
 * Error:(27, 18) 错误: Members injection methods may only return the injected type or void.
 *
 */
@Component(modules = {ModuleInjectModule.class})
public interface ModuleInjectComponent {
    ModuleInject inject();
}
